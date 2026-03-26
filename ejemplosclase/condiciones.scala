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
// generar edades más variadas
val edades = List.fill(nombres.length)(Random.between(10, 80))

val personas = nombres.zip(edades)

for ((nombre, edad) <- personas) {

  lazy val verificacion = {
    println("Evaluando acceso...")
    
    val categoria =
      if (edad < 18) "Menor"
      else if (edad < 60) "Adulto"
      else "Adulto mayor"

    val costo =
      if (categoria == "Menor") 50
      else if (categoria == "Adulto") 100
      else 30

    (categoria, costo)
  }

  val (categoria, costo) = verificacion

  println(s"$nombre - Edad: $edad - Categoria: $categoria - Costo: $$${costo}")
}
