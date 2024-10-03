package FunWithScala.TypeInference

object PlayGround {
  val businessName = "Montreux Jazz Café"

  def squareOf(x: Int) = x * x
  //  def fac(n: Int) = if (n == 0) 1 else n * fac(n - 1)

  case class MyPair[A, B](x: A, y: B)

  val p = MyPair(1, "scala") // type: MyPair[Int, String]

  def id[T](x: T) = x

  val q = id(1) // type: Int
  println(s"${p.x.getClass} ${p.y.getClass}")
  println(s"${q.getClass}")

  Seq(1, 3, 4).map(x => x * 2) // List(2, 6, 8)

  var obj = new AnyRef
  println(s"${obj.getClass}")

}
