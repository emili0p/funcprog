// hacer una lista con el nombre de todos
// convirtiendolo en una matriz con la edad de otra lista almacenandolo
// con un ciclo

// lista de nombres
import scala.util.Random
val nombres = List(
  "Angel",
  "Josue",
  "luis",
  "fany",
  "mariana",
  "myrka",
  "teresa",
  "nelly",
  "rodolfo",
  "gael",
  "lalo",
  "david",
  "toño",
  "rene",
  "oscar",
  "lupita",
  "santiago",
  "emilio",
  "cruz",
  "brian"
)
val cantidadalumnos = nombres.length

// lista de edades
val edades = List.fill(cantidadalumnos)(Random.between(17, 23))

// combinar en una matriz (lista de tuplas)
val personas = nombres.zip(edades)
for ((nombre, edad) <- personas) {

  val mensaje = {
    if (edad >= 30) "adulto"
    else if (edad >= 18) "joven"
    else "menor"
  }

  println(s"$nombre tiene $edad años -> $mensaje")
}
