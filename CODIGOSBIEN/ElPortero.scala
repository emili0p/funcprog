@main def run() =

  val edad = 16
  val tieneCredencial = false

  lazy val verificacion =
    println("Evaluando acceso...")
    edad >= 18 && tieneCredencial

  print(verificacion)

  val usuario = "admin"
  val edad2 = 22
  val activo = true

  lazy val acceso =
    println("Validando acceso...")
    (edad2 >= 18 && activo) || usuario == "admin"

  val mensaje =
    if acceso then "Acceso concedido"
    else "Acceso denegado"

  println(mensaje)
