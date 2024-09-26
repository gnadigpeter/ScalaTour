package Traits
import Traits.Greeter

trait Greeter:
  def greet(name: String): Unit =
    println("Hello, " + name + "!")
