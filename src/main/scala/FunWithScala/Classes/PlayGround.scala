package FunWithScala.Classes

object PlayGround:
  val point1_ = Point(2, 3)
  println(point1_.x) // prints 2
  println(point1_) // prints (2, 3)

  val origin = Point() // x and y are both set to 0
  val point1 = Point(1) // x is set to 1 and y is set to 0
  println(origin)
  println(point1) // prints (1, 0)

  val point2 = Point(y = 2)
  println(point2) // prints (0, 2)

  val pointT2 = Point2()
  println(pointT2)
  pointT2.x = 99
  println(pointT2)
  pointT2.y = 101
  println(pointT2)
