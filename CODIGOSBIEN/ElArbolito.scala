sealed trait Arbol
case class Hoja(value: Int) extends Arbol
case class Nodo(izquierdo: Arbol, derecha: Arbol) extends Arbol

@main def run() =

  val miArbolito =
    Nodo(
      Hoja(10),
      Nodo(
        Hoja(20),
        Hoja(30)
      )
    )

  println(miArbolito.getClass.getSimpleName)

  println(miArbolito.isInstanceOf[Hoja])

  println(miArbolito.isInstanceOf[Nodo])

  def sumArbol(arbol: Arbol): Int = arbol match
    case Hoja(value) => value
    case Nodo(izquierdo, derecho) => sumArbol(izquierdo) + sumArbol(derecho)

  println(sumArbol(miArbolito))

  def contarNodos(arbol: Arbol): Int = arbol match
    case Hoja(_) => 1
    case Nodo(izquierdo, derecho) => 1 + contarNodos(izquierdo) + contarNodos(derecho)

  println(contarNodos(miArbolito))

  def maxArbol(arbol: Arbol): Int = arbol match
    case Hoja(value) => value
    case Nodo(izquierdo, derecho) => maxArbol(izquierdo) max maxArbol(derecho)

  println(maxArbol(miArbolito))
