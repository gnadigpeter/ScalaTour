package FunWithScala.Traits

import scala.collection.mutable.ArrayBuffer

object PlayGround {
  trait HairColor

  trait Iterator[A]:
    def hasNext: Boolean

    def next(): A
  end Iterator


  class IntIterator(to: Int) extends Iterator[Int]:
    private var current = 0

    override def hasNext: Boolean = current < to

    override def next(): Int =
      if hasNext then
        val t = current
        current += 1
        t
      else
        0
  end IntIterator

  val iterator = IntIterator(10)
  iterator.next() // returns 0
  iterator.next() // returns 1
  println(iterator.next())
  println(iterator.next())
  for i <- 1 to 10 do {
    println(iterator.next())
  }


  trait Pet:
    val name: String

  class Cat(val name: String) extends Pet

  class Dog(val name: String) extends Pet

  val dog = Dog("Harry")
  val cat = Cat("Sally")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name)) // Prints Harry Sally
  
  
  
}
