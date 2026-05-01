@main def run() =

  val r1 = 1 to 5
  val r2 = 1 until 5
  val r3 = 1 to 10 by 2
  val r4 = 10 to 1 by -1

  println(r1)
  println(r2)
  println(r3)
  println(r4)
  println(r1.toList)
  println(r3.toList)
