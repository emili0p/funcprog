// most things were taken from
// https://github.com/martynafford/game-of-life-ncurses.git
// can be buggy
// se compila con scalac gameoflife.scala
// emilio izquierdo montero
import org.jline.terminal.TerminalBuilder
import org.jline.utils.NonBlockingReader
import scala.util.Random

object JuegoDeLaVida {

  // Definimos la malla como una matriz inmutable de booleanos
  // true = celula viva, false = celula muerta

  type Malla = Vector[Vector[Boolean]]

  // funcion en java que permite leer la terminal 
  val terminal = TerminalBuilder.builder().system(true).build()
  val reader: NonBlockingReader = terminal.reader()
  // dimensiones de la terminal 
  val ancho = terminal.getWidth
  val altoReal = terminal.getHeight - 1
  val alto = altoReal * 2 

  // generamos un monton de celulas aleatorias para el estado inical del juego
  def mallaAleatoria: Malla =
    Vector.fill(alto, ancho)(Random.nextBoolean())

  // esta funcion cuenta cuantos vecinos vivos tiene una celula en posición (x, y)
  def contarVecinos(m: Malla, x: Int, y: Int): Int = {
    val dirs = for {
      dx <- -1 to 1
      dy <- -1 to 1
      if !(dx == 0 && dy == 0)
    } yield (dx, dy)

    // contamos cuantos estan vivos 
    dirs.count { case (dx, dy) =>
      val nx = x + dx
      val ny = y + dy
      // validamos que esten dentro de nuestra terminal 
      nx >= 0 && nx < alto &&
      ny >= 0 && ny < ancho &&
      m(nx)(ny)
    }
  }

   // Determina el siguiente estado de una celula según las reglas de Conway
  def siguienteCelda(m: Malla, x: Int, y: Int): Boolean = {
    val v = m(x)(y)
    val n = contarVecinos(m, x, y)

    (v, n) match {
      case (true, n) if n < 2 => false // soledad, muerte  
      case (true, 2 | 3)      => true // acompañada , vive
      case (true, n) if n > 3 => false // sobrepoblacion
      case (false, 3)         => true // reproduccion
      case _                  => false
    }
  }

  // se genera una nueva malla en base a lo que calcule la funcion siguienteCelda
  def siguiente(m: Malla): Malla =
    Vector.tabulate(alto, ancho)((x, y) => siguienteCelda(m, x, y))

  def imprimir(m: Malla): Unit = {
    print("\u001b[H") // mover cursor arriba
    // recorremos de 2 en 2 filas (porque cada caracter representa 2 celdas)
    for (y <- 0 until alto by 2) {
      val fila = (0 until ancho).map { x =>
        val arriba = m(y)(x)
        val abajo = if (y + 1 < alto) m(y + 1)(x) else false

          // Elegimos el carácter adecuado según combinación
        (arriba, abajo) match {
          case (true, true)  => "█"
          case (true, false) => "▀"
          case (false, true) => "▄"
          case _             => " "
        }
      }
      println(fila.mkString)
    }
  }

  // loop prinicipal 
  def correr(m0: Malla): Unit = {
    var actual = m0
    var salir = false

    // para que detecte entradas de teclado y poder salir del programa 
    terminal.enterRawMode()

    try {
      while (!salir) {
        imprimir(actual)
        // Calculamos siguiente generacion de celulas (inmutable)
        actual = siguiente(actual)

        // leer input sin bloquear
        val c = reader.read(10) // timeout ms
        if (c == 'q') salir = true

        // velocidad de la animacion
        Thread.sleep(800)
      }
    } finally {
      terminal.close()
    }
  }

  def main(args: Array[String]): Unit = {
    print("\u001b[2J") // limpiar pantalla
    correr(mallaAleatoria)
  }
}
