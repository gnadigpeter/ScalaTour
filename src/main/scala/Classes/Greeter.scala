package Classes

import Traits.Greeter



class Greeter1(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}


class DefaultGreeter extends Greeter
class CustomizableGreeter(prefix: String, postfix: String) extends Greeter:
  override def greet(name: String): Unit =
    println(prefix + name + postfix)


