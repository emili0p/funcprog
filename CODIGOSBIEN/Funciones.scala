@main def run() =

  // Función pura: siempre devuelve el mismo resultado para los mismos argumentos
  // No tiene efectos secundarios
  def sumar(a: Int, b: Int): Int = a + b

  // Función pura: es una lambda sin efectos secundarios
  val multiplicar = (a: Int, b: Int) => a * b

  // Función pura: recibe una función y un valor, no modifica nada externo
  def aplicar(f: Int => Int, x: Int): Int = f(x)

  // Función pura: transforma el valor sin efectos secundarios
  val triple = (x: Int) => x * 3

  // Funciones impuras: println tiene efectos secundarios (I/O en consola)
  println(sumar(3, 4)) // impura por el println
  println(multiplicar(3, 4)) // impura por el println
  println(aplicar(triple, 5)) // impura por el println
  println(aplicar(x => x * x, 6)) // impura por el println
