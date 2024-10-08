package FunWithScala.CaseClasses

object PlayGround {
  case class Book(isbn: String)

  val frankenstein = Book("978-0486282114")
  println(frankenstein)
  println(frankenstein.isbn)


  case class Message(sender: String, recipient: String, body: String)

  val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

  println(message1.sender) // prints guillaume@quebec.ca
  //  message1.sender = "travis@washington.us" // this line does not compile

  case class Message2(sender: String, recipient: String, body: String)

  val message2 = Message2("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val message3 = Message2("jorge@catalonia.es", "guillaume@quebec.ca", "Com va?")
  val messagesAreTheSame = message2 == message3 // true
  println(s"$message2 \n$message3 \n$messagesAreTheSame")

  case class Message3(sender: String, recipient: String, body: String)

  val message4 = Message3("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
  val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
  message5.sender // travis@washington.us
  message5.recipient // claire@bourgogne.fr
  message5.body // "Me zo o komz gant ma amezeg"
  println(message4)
  println(message5)
}
