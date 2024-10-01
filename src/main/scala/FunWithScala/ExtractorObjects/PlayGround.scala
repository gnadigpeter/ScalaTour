package FunWithScala.ExtractorObjects

import scala.util.Random

object PlayGround {
  object CustomerID:

    def apply(name: String) = s"$name--${Random.nextLong()}"

    def unapply(customerID: String): Option[String] =
      val stringArray: Array[String] = customerID.split("--")
      if stringArray.tail.nonEmpty then Some(stringArray.head) else None

  val customer1ID = CustomerID("Sukyoung") // Sukyoung--23098234908
  println(customer1ID)
  customer1ID match
    case CustomerID(name) => println(name) // prints Sukyoung
    case _ => println("Could not extract a CustomerID")

  val customer2ID = CustomerID("Nico")
  val CustomerID(name) = customer2ID
  println(name) // prints Nico
  val name02 = CustomerID.unapply(customer2ID).get
  println(name02)

  val uName = "Bela"
  var CustomerID(name01) = CustomerID(uName)
  println(name01)
}
