@main
def main(): Unit = {
  println("Hello world!")
  //  FunWithScala.BasicFun
  //  FunWithScala.UnifiedTypes
  //  FunWithScala.Classes.PlayGround
  //  FunWithScala.DefaultParameterValues.PlayGround
  //  FunWithScala.NamedArguments.PlayGround
  //  FunWithScala.Traits.PlayGround
  //  FunWithScala.Tuples.PlayGround
  //  FunWithScala.ClassCompositionWithMixins.PlayGround
  //  FunWithScala.HigherOrderFunctions.PlayGround
  //  FunWithScala.NestedMethods.PlayGround
  //  FunWithScala.MultipleParameterLists.PlayGround
  //  FunWithScala.CaseClasses.PlayGround
  //  FunWithScala.PatternMarching.PlayGround
  //  FunWithScala.SingeltonObjects.PlayGround
  //  FunWithScala.RegularExpressionPatterns.PlayGround
  //  FunWithScala.ExtractorObjects.PlayGround
  //  FunWithScala.ForComprehensions.PlayGround
  //  FunWithScala.GenericClasses.PlayGround
  //  FunWithScala.Variances.PlayGround
  //  FunWithScala.UpperTypeBounds.PlayGround
  //  FunWithScala.LowerTypeBounds.PlayGround
  //  FunWithScala.InnerClasses.PlayGround

  trait Buffer {
    type T
    val element: T
  }

  abstract class SeqBuffer extends Buffer {
    type U
    type T <: Seq[U]

    def length = element.length
  }

  abstract class IntSeqBuffer extends SeqBuffer {
    type U = Int
  }

  def newIntSeqBuf(elem1: Int, elem2: Int): IntSeqBuffer =
    new IntSeqBuffer {
      type T = List[U]
      val element = List(elem1, elem2)
    }

  val buf = newIntSeqBuf(7, 8)
  println("length = " + buf.length)
  println("content = " + buf.element)



  abstract class Buffer2[+T] {
    val element: T
  }
  abstract class SeqBuffer2[U, +T <: Seq[U]] extends Buffer2[T] {
    def length = element.length
  }

  def newIntSeqBuf2(e1: Int, e2: Int): SeqBuffer2[Int, Seq[Int]] =
    new SeqBuffer2[Int, List[Int]] {
      val element = List(e1, e2)
    }

  val buf2 = newIntSeqBuf2(7, 8)
  println("length = " + buf2.length)
  println("content = " + buf2.element)


}