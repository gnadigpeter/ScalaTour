package FunWithScala.GenericClasses

object PlayGround {
  class Stack[A] {
    private var elements: List[A] = Nil

    def push(x: A): Unit =
      elements = x :: elements

    def peek: A = elements.head

    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }

  //  var list = Stack[Int]
  //  list.push(1)
  //  list.push(2)
  //  list.push(3)
  //  println(list.peek)
  //  println(list.pop())
  //  println(list.peek)
  //  println(list.pop())
  //  println(list.peek)
  //  println(list.pop())
  //  println(list.peek)

  class Fruit

  class Apple extends Fruit

  class Banana extends Fruit

  val stack = Stack[Fruit]
  val apple = Apple()
  val banana = Banana()

  stack.push(apple)
  stack.push(banana)

  println(stack.peek)
}
