package FunWithScala.ImplicitConversions

object PlayGround {

  def randomFunction(x: Long): Unit = {
    println(x.getClass)
  }

  var xValue: Int = 5
  randomFunction(xValue)

}
