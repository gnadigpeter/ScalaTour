package FunWithScala.NestedMethods

object PlayGround {
  def factorial(x: Int): Int =
    def fact(x: Int, accumulator: Int): Int =
      if x <= 1 then accumulator
      else fact(x - 1, x * accumulator)

    fact(x, 1)

  println("Factorial of 1: " + factorial(1))
  println("Factorial of 2: " + factorial(2))
  println("Factorial of 3: " + factorial(3))

}
