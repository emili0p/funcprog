object Main {
  def encoding(str: String): String = {
    str.foldLeft(List.empty[(Char, Int)]) {
      case (Nil, c) => List((c, 1))
      case ((ch, count) :: tail, c) =>
        if (ch == c) (ch, count + 1) :: tail
        else (c, 1) :: (ch, count) :: tail
    }
    .reverse
    .map { case (c, count) => s"$c$count" }
    .mkString
  }

  def main(args: Array[String]): Unit = {
    val str = "wwwwaaadexxxxxxywww"
    println(encoding(str))
  }
}
