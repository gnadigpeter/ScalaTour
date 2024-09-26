package FunWithScala

object UnifiedTypes:
  val list: List[Any] = List(
    "a string",
    732, // an integer
    'c', // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )

  list.foreach(element => println(element))


  val x: Long = 987654321
  val y: Float = x.toFloat // 9.8765434E8 (note that some precision is lost in this case)

  val face: Char = '☺'
  val number: Int = face // 9786

  println(x)
  println(y)
  println(face)
  println(number)

  val face2: Char = number.toChar
  println(face2)


  val xx: Long = 987654321
  val yy: Float = x // 9.8765434E8
  val zz: Long = y.toLong

  println(xx)
  println(yy)
  println(zz)



  