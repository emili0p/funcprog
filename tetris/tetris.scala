import scala.util.Random
import java.time.temporal.TemporalQuery

enum Tetriminio:
  case I, O, T, S, Z, J, L

  case class Coord(x: Int, y: Int)

case class Block(
    shape: Tetriminio,
    origin: Coord,
    extra: list[Coord]
)

enum Direction:
  case Left, Right, Down

// board conformado por cordenadasy piezas

type Board = Map[Coord, Tetriminio]

// valores principales del juego

  case class Game(
    level: Int,
    block: Block,
    nextShape: list[TetrimiTetriminio],
    score: Int,
    board: Board,
    progression: Boolean
)

// constantes

val boardAncho = 10
val boardAltura = 20
val startOrigin = Coord(6, 20) // donde empiezan las piezas, arriba a al centro

// utilidades

def traducirCoord(c: Coord, d: Direction, n: Int = 1): Coord =
  d match
    case Direction.Left  => c.copy(c.x - n)
    case Direction.Right => c.copy(c.x + n)
    case Direction.Down  => c.copy(c.y - n)

def traducirBloque(b: Block, d: Direccion, n: Int = 1): Coord =
  b.copy(
    origin = traducirCoord(b.origin, d, n),
    extra = b.extra.map(c => traducirCoord(c, d, n))
  )

// figuras

def rellenoCelulas(t: Tetriminio): List[Coord] = t match
  case Tetriminio.I => List((-2, 0), (-1, 0), (1, 0))
  case Tetriminio.O => List((-1, 0), (-1, -1), (0, -1))
  case Tetriminio.S => List((-1, -1), (0, -1), (1, 0))
  case Tetriminio.Z => List((-1, 0), (0, -1), (1, -1))
  case Tetriminio.L => List((-1, -1), (-0, 0), (1, 0))
  case Tetriminio.J => List((-1, 0), (1, 0), (1, -1))
  case Tetriminio.T => List((-1, 0), (0, -1), (1, 0)).map { case (x, y) => Coord(x, y) }

def iniciarBloque(t: Tetriminio): Block =
  val celulas = rellenoCelulas(t).map(c => Coord(c.x + startOrigin.x, c.y + startOrigin.y))
  Block(t, startOrigin, celulas)

// cordenadas feas
def coords(b: Block): List[Coord] =
  b.origin :: b.extra

// validaciones

def estaEnLimites(c: Coord): Boolean =
  c.x >= 1 && c.x <= boardAncho && c.y >= 1

def estaLibre(board: Board, c: Coord): Boolean =
  !board.contains(c)

// para ver si es una posicion valida tenemos que ver si el bloque esta
// dentro de los limites y esa posicion esta libre
def esPosicionValidadeBloque(board: Board, b: Block): Boolean =
  coords(b).forall(c => estaEnLimites(c) && estaLibre(board, c))

def shift(game: Game, dir: Direction): Game =
  val candidato = traducirBloque(game.block, dir)
  if esPosicionValidadeBloque(game.board, candidato)
    game.copy(block = candidato)
  else game

def rotarCrudo(b: Block): Block =
  if b.shape == Tetriminio.O then b
  else 
    val o = b.origin
    def rotar(c: Coord): Coord =
      val x = c.x - o.x
      val y = c.y - o.y
      Coord(o.x + o.y -x) 

  b.copy(extra = b.extra.map(rotar))

def rotar(game: Game): Game = 
  val candidato = rotarCrudo(game.block)
  if esPosicionValidadeBloque(game.board, candidato)
    game.copy(block = candidato)
  else game 


def gravedad(game: Game): Game =
    shift(game, Direction.Down)

def congelarBloque(game: Game): Game =
  val nuevaCelula = coords(game.block).map(c => c -> game.block.shape).toMap
  game.copy(board = game.board ++ nuevaCelula)

def limpiarCompletoFile(game: Game): (Game, Int) =
  val grupos = game.board.groupBy(_._1-y)
  
  val filaCompleta = grupos.collect{
    case (y, celulas) if celulas.size == boardAncho => y
  }.toList

  val nuevoBoard = 
    game.board.filterNot((coords(, _) => filaCompleta.contains(coords(.y))).map { case (Coord(x,y), t)=>
    val shift = filaCompleta.count(_ < y)
    Coord(x,y -shift) -> t
    }
// probablemente haya un error de tipado aqui somewhere 
  val limpiado = filaCompleta.size
  (
    game.copy(
      board = nuevoBoard,
      limpiado = game.limpiado + limpiado
      ),
    limpiado
    )

// score

def actualizarScore(game: Game, lineas: Int): Game =
  val puntos = lineas match
  case 1 => 40
  case 2 => 100
  case 3 => 300
  case 4 => 1200 
  case _ =>

  val nuevaPuntuacion = game.score + (game.level + 1) * puntos
  game.copy(score = nuevaPuntuacion)


// loop de mierda 

def timeStep(game: Game): Game = 
  val moved = gravedad(game)
  if moved.block == game.block then
  val congelar = congelarBloque(game)
  val (clearedGame, lineas) = limpiarCompletoFile(congelado)
  actualizarScore(clearedGame, lineas)
  else moved


