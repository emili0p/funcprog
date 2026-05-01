sealed trait ArbolN[+A]
case class HojaN[A](value: A) extends ArbolN[A]
case class NodoN[A](izquierdo: ArbolN[A], derecha: ArbolN[A]) extends ArbolN[A]

@main def run() =

  val nombresArbol =
    NodoN(
      HojaN("Emilioooooooooooooo"),
      NodoN(
        HojaN("Francisca"),
        HojaN("del carmen")
      )
    )

  println(nombresArbol)
