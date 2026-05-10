sealed trait DecisionTree

case class DecisionNode(
    condicion: SensorData => Boolean,
    izquierda: DecisionTree,
    derecha: DecisionTree
) extends DecisionTree

case class Hoja(resultado: EstadoSalud) extends DecisionTree

object Evaluador {

  def evaluar(arbol: DecisionTree, data: SensorData): EstadoSalud =
    arbol match {

      case Hoja(resultado) =>
        resultado

      case DecisionNode(condicion, izquierda, derecha) =>

        if (condicion(data))
          evaluar(izquierda, data)
        else
          evaluar(derecha, data)
    }
}
object Arboles {
  /*
    Reglas del ecosistema:

    - Si CO2 > 800 => Critico
    - Si temperatura > 32 => Alerta
    - Si humedad < 25 => Alerta
    - En cualquier otro caso => Estable
   */

  val arbol: DecisionTree =
    DecisionNode(
      data => data.co2 > 800,
      Hoja(Critico),
      DecisionNode(
        data => data.temp > 32 || data.humedad < 25,
        Hoja(Alerta),
        Hoja(Estable)
      )
    )
}
