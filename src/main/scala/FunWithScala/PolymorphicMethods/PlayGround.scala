package FunWithScala.PolymorphicMethods

object PlayGround {
  def listOfDuplicates[A](x: A, length: Int): List[A] = {
    if (length < 1)
      Nil
    else
      x :: listOfDuplicates(x, length - 1)
  }

  println(listOfDuplicates[Int](3, 4)) // List(3, 3, 3, 3)
  println(listOfDuplicates("La", 8)) // List(La, La, La, La, La, La, La, La)

  var rList: List[Int] = Nil
  rList = 1 :: rList
  println(rList)
  rList = 2 :: rList
  println(rList)
  rList = rList.appended(3)
  println(rList)


}
