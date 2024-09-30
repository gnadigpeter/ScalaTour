package FunWithScala.MultipleParameterLists

object PlayGround {

  trait Iterable[A]:
    def foldLeft[B](z: B)(op: (B, A) => B): B
  end Iterable

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((m, n) => m + n)
  println(res) // 55

  def foldLeft1[A, B](as: List[A], b0: B, op: (B, A) => B) = ???

  def notPossible = foldLeft1(numbers, 0, _ + _)

  //That’s because Scala won’t be able to infer the type of the function _ + _,
  // as it’s still inferring A and B. By moving the parameter op to
  // its own parameter list, A and B are inferred in the first parameter
  // list. These inferred types will then be available to the second
  // parameter list and _ + _ will 
  // match the inferred type (Int, Int) => Int
  def firstWay = foldLeft1[Int, Int](numbers, 0, _ + _)

  def secondWay = foldLeft1(numbers, 0, (a: Int, b: Int) => a + b)

  //This definition doesn’t need any type hints and can infer all of its type parameters.
  def foldLeft2[A, B](as: List[A], b0: B)(op: (B, A) => B) = ???

  def possible = foldLeft2(numbers, 0)(_ + _)

  def execute(arg: Int)(using ec: scala.concurrent.ExecutionContext) = ???

  val numbers2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val numberFunc = numbers2.foldLeft(List[Int]()) _

  val squares = numberFunc((xs, x) => xs :+ x * x)
  println(squares) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

  val cubes = numberFunc((xs, x) => xs :+ x * x * x)
  println(cubes) // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)


  // version with multiple parameter lists
  def addMultiple(n1: Int)(n2: Int) = n1 + n2

  // two different ways of arriving at a curried version instead
  def add(n1: Int, n2: Int) = n1 + n2

  val addCurried1 = (add _).curried
  val addCurried2 = (n1: Int) => (n2: Int) => n1 + n2
  // regardless, all three call sites are identical
  addMultiple(3)(4) // 7
  addCurried1(3)(4) // 7
  addCurried2(3)(4) // 7

  println(addMultiple(3)(4))
  println(addCurried1(3)(4))
  println(addCurried2(3)(4))
  println(add(3, 4))
}
