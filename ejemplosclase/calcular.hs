calcularTotal :: Double -> Double
calcularTotal precio = precio + iva precio - descuento precio
  where
    iva monto = monto * 0.16
    descuento monto
        monto >= 1000 = monto * 0.10
        otherwise     = 0.0
