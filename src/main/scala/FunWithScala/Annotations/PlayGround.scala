package FunWithScala.Annotations

import scala.annotation.tailrec

object PlayGround {

  object DeprecationDemo extends App {
    @deprecated("deprecation message", "release # which deprecates method")
    def hello = "hola"

  }

  val a = DeprecationDemo
  println(a.hello)


  def factorial(x: Int): Int = {

    @tailrec
    def factorialHelper(x: Int, accumulator: Int): Int = {
      if (x == 1) accumulator else factorialHelper(x - 1, accumulator * x)
    }

    factorialHelper(x, 1)
  }

  //  def factorial2(x: Int): Int = {
  //    @tailrec
  //    def factorialHelper(x: Int): Int = {
  //      if (x == 1) 1 else x * factorialHelper(x - 1)
  //    }
  //
  //    factorialHelper(x)
  //  }
  //Java:
  //  @interface Source {
  //    public String url();
  //    public String mail();
  //  }
  //Scala:
  trait Source {
    def url: String

    def mail: String
  }
  //Java
  //  @Source(url = "https://coders.com/",
  //    mail = "support@coders.com")
  //  public class MyJavaClass extends TheirClass.


  //Scala
  //  @Source(url = "https://coders.com/",
  //    mail = "support@coders.com")
  //  class MyScalaClass

  //JAVA
  //  @interface SourceURL {
  //    public String value();
  //    public String mail() default "";
  //  }
  //  @SourceURL("https://coders.com/")
  //  public class MyJavaClass extends TheirClass ...

  //Scala
  //  @SourceURL("https://coders.com/")
  //  class MyScalaClass


  //JAVA
  //  @SourceURL(value = "https://coders.com/",
  //    mail = "support@coders.com")
  //  public class MyJavaClass extends TheirClass.


  //SCALA
  //  @SourceURL("https://coders.com/",
  //    mail = "support@coders.com")
  //  class MyScalaClass

}
