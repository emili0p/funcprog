class Vector2D(val x: Int, val y: Int) {

 def +(otro: Vector2D): Vector2D =
    new Vector2D(
      this.x + otro.x,
      this.y + otro.y
    )
  override def toString: String =
    s"($x, $y)"
}
