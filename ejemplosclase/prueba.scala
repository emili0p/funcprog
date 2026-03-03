object Test {

  def suma(x: Int, y: Int): Int = {
    x + y   // ❌ falta cerrar llave del método

  def main(args: Array[String]): Unit = {
    val a = 10
    val b = 20

    println("Resultado: " + suma(a, b)   // ❌ falta paréntesis

    if (a > b) {
      println("a es mayor")
    else {   // ❌ else sin cerrar el bloque del if
      println("b es mayor")
    }

    val lista = List(1, 2, 3
    println(lista.map(_ * 2))  // ❌ falta cerrar paréntesis en List
  }
}
