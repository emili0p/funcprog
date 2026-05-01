@main def run() =

  val nombre = "Emilio"
  val edad = 21
  val promedio = 5.4
  val activo = true

  val arreglo = Array(("Pepe", 17), ("Luis", 21))

  println(nombre)
  println(edad)
  println(promedio)
  println(activo)
  println(arreglo.mkString(", "))
