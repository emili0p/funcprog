object FuenteDatos {

  def streamSensores: LazyList[SensorData] = {

    def loop(id: Int): LazyList[SensorData] = {

      val dato = SensorData(
        id,
        20 + Math.random() * 20,
        Math.random() * 100,
        300 + (Math.random() * 700).toInt
      )

      dato #:: loop(id + 1)
    }

    loop(1)
  }
}
