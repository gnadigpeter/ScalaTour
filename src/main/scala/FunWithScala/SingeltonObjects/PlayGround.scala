package FunWithScala.SingeltonObjects

import FunWithScala.SingeltonObjects.logging.Logger.info

import scala.math.{Pi, pow}


object PlayGround {
  class Project(name: String, daysToComplete: Int)

  class Test:
    val project1 = Project("TPS Reports", 1)
    val project2 = Project("Website redesign", 5)
    info("Created projects")  // Prints "INFO: Created projects"

  val a = Test()


  case class Circle(radius: Double):

    import Circle.*

    def area: Double = calculateArea(radius)

  object Circle:
    private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)


  val circle1 = Circle(5.0)

  circle1.area
  println(circle1)
  println(circle1.area)

  class Email(val username: String, val domainName: String)

  object Email:
    def fromString(emailString: String): Option[Email] =
      emailString.split('@') match
        case Array(a, b) => Some(Email(a, b))
        case _ => None

  val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
  scalaCenterEmail match
    case Some(email) => {
      println(email.getClass)
      email.getClass.getDeclaredFields.foreach { field => println(field) }
    }
    case None => println("Invalid email")
  end match

  scalaCenterEmail match
    case Some(email) => println(
      s"""Registered an email
         |Username: ${email.username}
         |Domain name: ${email.domainName}
     """.stripMargin)
    case None => println("Error: could not parse email")
}
