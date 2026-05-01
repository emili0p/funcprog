@main def run() =

  // Lazy val: se evalúa hasta que se usa
  lazy val x = {
    println("Evaluando x")
    10
  }

  println("Inicio")
  println(x) // aquí se evalúa
  println(x) // ya no se vuelve a evaluar

  // Call-by-name: evaluación perezosa en parámetros
  def usar(y: => Int) =
    println(y)

  def costoso() = {
    println("Cálculo costoso")
    42
  }

  usar(costoso()) // se evalúa solo cuando se usa dentro de usar
