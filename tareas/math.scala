// al momento de importar poner _ hace que se traiga todo de una liberia !!
import scala.math._ // contiene cosas como sin, cos, Pi, etc.

// Función que recibe otra función (el parametro f), lo demas son los numeros con los que se va a integrar
// siendo f la propia funcion dentro de la integral
def integrar(f: Double => Double, a: Double, b: Double, pasos: Int): Double = {

  // calculamos el diferencial comparando el limite inferior con el superior
  // divido entre pasos
  val dx = (b - a) / pasos
  var suma = 0.0

  // _ podría usarse aquí si NO necesitáramos el índice donde se esta sumando
  // _ significa: no me importa este valor
  // otros lenguajes como rust (el cual es genial) el _ tambien se puede usar como placeholder
  // o para ignorar un valor

  for (i <- 0 until pasos) {
    val x = a + i * dx
    suma += f(x) * dx
  }

  suma
}
