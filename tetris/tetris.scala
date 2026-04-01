import scala.util.Random

enum Tetriminio:
  case I, O, T, S, Z, J, L

  case class Coord(x: Int, y: Int)
case class Block(
    shape: Tetriminio,
    origin: Coord,
    extra: list[Coord]
)
