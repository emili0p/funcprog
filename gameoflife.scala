// most things were taken from
// https://github.com/martynafford/game-of-life-ncurses.git
// can be buggy
// se compila con scalac gameoflife.scala
// emilio izquierdo montero
import org.jline.terminal.TerminalBuilder
import org.jline.utils.NonBlockingReader
import scala.util.Random

object JuegoDeLaVida {

  type Malla = Vector[Vector[Boolean]]

  val terminal = TerminalBuilder.builder().system(true).build()
  val reader: NonBlockingReader = terminal.reader()

  val ancho = terminal.getWidth
  val altoReal = terminal.getHeight - 1
  val alto = altoReal * 2 // duplicamos resolución vertical

  def mallaAleatoria: Malla =
    Vector.fill(alto, ancho)(Random.nextBoolean())

  def contarVecinos(m: Malla, x: Int, y: Int): Int = {
    val dirs = for {
      dx <- -1 to 1
      dy <- -1 to 1
      if !(dx == 0 && dy == 0)
    } yield (dx, dy)

    dirs.count { case (dx, dy) =>
      val nx = x + dx
      val ny = y + dy
      nx >= 0 && nx < alto &&
      ny >= 0 && ny < ancho &&
      m(nx)(ny)
    }
  }

  def siguienteCelda(m: Malla, x: Int, y: Int): Boolean = {
    val v = m(x)(y)
    val n = contarVecinos(m, x, y)

    (v, n) match {
      case (true, n) if n < 2 => false
      case (true, 2 | 3)      => true
      case (true, n) if n > 3 => false
      case (false, 3)         => true
      case _                  => false
    }
  }

  def siguiente(m: Malla): Malla =
    Vector.tabulate(alto, ancho)((x, y) => siguienteCelda(m, x, y))

  def imprimir(m: Malla): Unit = {
    print("\u001b[H") // mover cursor arriba

    for (y <- 0 until alto by 2) {
      val fila = (0 until ancho).map { x =>
        val arriba = m(y)(x)
        val abajo = if (y + 1 < alto) m(y + 1)(x) else false

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

  def correr(m0: Malla): Unit = {
    var actual = m0
    var salir = false

    terminal.enterRawMode()

    try {
      while (!salir) {
        imprimir(actual)
        actual = siguiente(actual)

        // leer input sin bloquear
        val c = reader.read(10) // timeout ms
        if (c == 'q') salir = true

        Thread.sleep(50)
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
