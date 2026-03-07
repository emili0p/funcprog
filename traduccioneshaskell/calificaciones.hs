calcularPromedio :: Double -> Double -> Double -> IO Double
calcularPromedio calificacion1 calificacion2 calificacion3 = do
    let promFinal = promedio calificacion1 calificacion2 calificacion3
    estatus promFinal
    return promFinal
  where
    promedio :: Double -> Double -> Double -> Double
    promedio a b c = (a + b + c) / 3

    estatus :: Double -> IO ()
    estatus prom =
        if prom >= 70
            then putStrLn "Felicidades usted es regular"
            else putStrLn "Usted es irregular"
