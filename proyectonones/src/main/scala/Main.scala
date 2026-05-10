import Evaluador._
import Arboles._

@main def run(): Unit = {
  println("= SIMULACIÓN BIOCLIMÁTICA =\n")

  val datos = FuenteDatos.streamSensores.take(5)

  val resultados = datos.map(d => (d, evaluar(arbol, d)))

  resultados.foreach { case (dato, estado) =>
    println(
      s"""
           |sensor #${dato.id}
           |temp: ${"%.2f".format(dato.temp)} °C
           |humedad: ${"%.2f".format(dato.humedad)} %
           |cO2: ${dato.co2} ppm
           |estado: $estado
           |-----------------------------------
           |""".stripMargin
    )
  }
}
