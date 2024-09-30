package FunWithScala.DefaultParameterValues

object PlayGround {
  def log(message: String, level: String = "INFO") = println(s"$level: $message")

  log("System starting") // prints INFO: System starting
  log("User not found", "WARNING") // prints WARNING: User not found

  val point1 = Point(y = 1)
  println(point1.x)
  println(point1.y)
  println(s"${point1.x}, ${point1.y}")

//  If we call A.func(), compiler cannot know whether the programmer intended to call func(x: Int = 34) or func(y: String = "abc").
//  object A:
//    def func(x: Int = 34): Unit
//
//    def func(y: String = "abc"): Unit
}
