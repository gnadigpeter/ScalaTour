package FunWithScala.PatternMarching

import scala.util.Random

object PlayGround {
  val x: Int = Random.nextInt(10)

  x match
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other"

  def matchTest(x: Int): String = x match
    case 1 => "one"
    case 2 => "two"
    case _ => "other"

  matchTest(3) // returns other
  matchTest(1) // returns one
  println(matchTest(3))
  println(matchTest(1))

  val y: Int = 2

  y match
    case 0 => "zero"
    case 1 => "one"
    case 2 => println("two")
    case _ => "other"


  sealed trait Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String =
    notification match
      case Email(sender, title, _) =>
        s"You got an email from $sender with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"You received a Voice Recording from $name! Click the link to hear it: $link"

  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms)) // prints You got an SMS from 12345! Message: Are you there?
  println(showNotification(someVoiceRecording)) // prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
  println("")

  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String =
    notification match
      case Email(sender, _, _) if importantPeopleInfo.contains(sender) =>
        "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function

  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

  val someSms2 = SMS("123-4567", "Are you there?")
  val someVoiceRecording2 = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(showImportantNotification(someSms2, importantPeopleInfo)) // prints You got an SMS from 123-4567! Message: Are you there?
  println(showImportantNotification(someVoiceRecording2, importantPeopleInfo)) // prints You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
  println(showImportantNotification(importantEmail, importantPeopleInfo)) // prints You got an email from special someone!

  sealed trait Device

  case class Phone(model: String) extends Device:
    def screenOff = "Turning screen off"

  case class Computer(model: String) extends Device:
    def screenSaverOn = "Turning screen saver on..."


  def goIdle(device: Device): String = device match
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn


}
