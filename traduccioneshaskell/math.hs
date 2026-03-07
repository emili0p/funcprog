import Prelude

-- función que recibe otra función y los límites de integración
integrar :: (Double -> Double) -> Double -> Double -> Int -> Double
integrar f a b pasos =
    let dx = (b - a) / fromIntegral pasos
        xs = [a + fromIntegral i * dx | i <- [0 .. pasos - 1]]
    in sum (map (\x -> f x * dx) xs)
