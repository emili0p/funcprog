case class SensorData(
    id: Int,
    temp: Double,
    humedad: Double,
    co2: Int
)

sealed trait EstadoSalud
case object Estable extends EstadoSalud
case object Alerta extends EstadoSalud
case object Critico extends EstadoSalud
