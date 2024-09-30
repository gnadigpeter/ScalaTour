package FunWithScala.NamedArguments

object PlayGround {
  def printName(first: String, last: String): Unit =
    println(s"$first $last")

  printName("John", "Public") // Prints "John Public"
  printName(first = "John", last = "Public") // Prints "John Public"
  printName(last = "Public", first = "John") // Prints "John Public"
  printName("Elton", last = "John") // Prints "Elton John"


  def printFullName(first: String, middle: String = "Q.", last: String): Unit =
    println(s"$first $middle $last")

  printFullName(first = "John", last = "Public") // Prints "John Q. Public"
  printFullName("John", last = "Public") // Prints "John Q. Public"
  printFullName("John", middle = "Quincy", "Public") // Prints "John Quincy Public"
  printFullName(last = "Public", first = "John") // Prints "John Q. Public"
  //  printFullName(last = "Public", "John")  // error: positional after named argument
}
