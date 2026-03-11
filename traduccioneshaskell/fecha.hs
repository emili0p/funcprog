import Data.Time

main :: IO ()
main = do
  diaActual <- utctDay <$> getCurrentTime
  putStrLn ("El día de hoy es: " ++ show diaActual)
