package FunWithScala.ContextualParametersImplicitParameters

object PlayGround {
  trait Comparator[A] {
    def compare(x: A, y: A): Int
  }

  object Comparator {
    implicit object IntComparator extends Comparator[Int] {
      def compare(x: Int, y: Int): Int = Integer.compare(x, y)
    }
    //    given Comparator[Int] with
    //      def compare(x: Int, y: Int): Int = 1 // -1

    implicit object StringComparator extends Comparator[String] {
      def compare(x: String, y: String): Int = x.compareTo(y)
    }
  }

  def max[A](x: A, y: A)(implicit comparator: Comparator[A]): A =
    if (comparator.compare(x, y) >= 0) x
    else y

  println(max(10, 6)) // 10
  println(max("hello", "world")) // world
  // does not compile:
  //  println(max(false, true))
  //         ^
  //     error: could not find implicit value for parameter comparator: Comparator[Boolean]
}
