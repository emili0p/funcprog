def calcularTotal(Precio: Double): Double = {
   def iva(monto: Double): Double = monto * 0.16
   def descuento(monto: Double): Double = {
     if (monto >= 1000) monto*0.10 else 0.0
  }
   Precio + iva(Precio) - descuento(Precio)
}

