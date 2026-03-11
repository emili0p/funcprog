def calcularPromedio(
    calificacion1: Double,
    calificacion2: Double,
    calificacion3: Double
): Double = {
  def promedio(a: Double, b: Double, c: Double): Double = { (a + b + c) / 3 }
  def estatus(prom: Double): Unit = {
    if (prom >= 70)
      println("Felicidades usted es regular")
    else
      println("Usted es irregular")
  }
  val promFinal = promedio(calificacion1, calificacion2, calificacion3)
  estatus(promFinal)
  promFinal
}
