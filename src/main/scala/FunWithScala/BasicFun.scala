package FunWithScala

import FunWithScala.BasicFun.{CustomizableGreeter, DefaultGreeter, Greeter1}

object BasicFun:
  println("Hello BasicFun!")

  println({
    val x = 1 + 1
    x * x
  })

  val addOne = (x: Int) => x + 1
  println(addOne(1)) // 2

  val add_ = (x: Int, y: Int) => x + y
  println(add_(1, 2)) // 3

  val getTheAnswer = () => 42
  println(getTheAnswer()) // 42

  val getSomething = () => {
    println("testing")
    41
    42
  }
  println(getSomething())

  def add(x: Int, y: Int): Int = {
    x + y
  }

  var addValue = add(1, 2)
  println(addValue)

  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

  println(addThenMultiply(1, 2)(3)) // 9
  var asd = addThenMultiply(5, 5)(2)
  println(asd)

  def name: String = System.getProperty("user.name")

  println("Hello, " + name + "!")

  def getSquareString(input: Double): String = {
    val square = input * input
    if (false) {
      square.toString
    } else {
      //return
      "test"
    }
  }

  println(getSquareString(2.5)) // 6.25

  class Greeter1(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }

  trait Greeter:
    def greet(name: String): Unit =
      println("Hello, " + name + "!")

  class DefaultGreeter extends Greeter

  class CustomizableGreeter(prefix: String, postfix: String) extends Greeter:
    override def greet(name: String): Unit =
      println(prefix + name + postfix)

  
  val greeter1 = Greeter1("Hello, ", "!!!")
  greeter1.greet("Scala dev")

  case class Point(x: Int, y: Int)

  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(2, 2)

  if point == anotherPoint then
    println(s"$point and $anotherPoint are the same.")
  else
    println(s"$point and $anotherPoint are different.")
  // ==> Point(1,2) and Point(1,2) are the same.

  if point == yetAnotherPoint then
    println(s"$point and $yetAnotherPoint are the same.")
  else
    println(s"$point and $yetAnotherPoint are different.")
// ==> Point(1,2) and Point(2,2) are different.

object IdFactory:
  private var counter = 0

  def create(): Int =
    counter += 1
    counter


  val newId: Int = IdFactory.create()
  println(newId)
  val newerId = IdFactory.create()
  println(newerId)

  val greeter = DefaultGreeter()
  greeter.greet("Scala DEV")

  val customizableGreeter = CustomizableGreeter("How are you, ", "?")
  customizableGreeter.greet("Scala DEV")
