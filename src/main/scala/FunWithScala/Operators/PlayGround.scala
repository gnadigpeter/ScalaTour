package FunWithScala.Operators

object PlayGround {

  println(10.+(1))
  println(10 + 1)

  case class Vec(x: Double, y: Double) {
    def +(that: Vec) = Vec(this.x + that.x, this.y + that.y)

    def -(that: Vec) = Vec(this.x - that.x, this.y - that.y)
  }

  val vector1 = Vec(1.0, 1.0)
  val vector2 = Vec(2.0, 2.0)

  val vector3 = vector1 + vector2
  println(s"vector: (${vector3.x} ${vector3.y})")
  vector3.x // 3.0
  vector3.y // 3.0
  val vector4 = vector1 - vector2
  println(s"vector: (${vector4.x} ${vector4.y})")


  case class MyBool(x: Boolean) {
    def and(that: MyBool): MyBool = if (x) that else this

    def or(that: MyBool): MyBool = if (x) this else that

    def negate: MyBool = MyBool(!x)

    def not(x: MyBool) = x.negate

    def xor(x: MyBool, y: MyBool) = (x or y) and not(x and y)
  }

  val a1 = MyBool(true)
  val a2 = MyBool(false)
  println(a1.and(a1))
  println(a1.and(a2))
  println(a1.or(a1))
  println(a1.or(a2))
  println(a1.not(a1))
  println(a1.xor(a1, a1))
  println(a1.xor(a1, a2))
  println(a1.xor(a2, a2))

}
