package FunWithScala.Variances

object PlayGround {

  class Foo[+A] // A covariant class

  class Bar[-A] // A contravariant class

  class Baz[A] // An invariant class


  class Box[A](var content: A)

  abstract class Animal {
    def name: String
  }

  case class Cat(name: String) extends Animal

  case class Dog(name: String) extends Animal


  val myAnimal2: Animal = Cat("Felix")

  val myCatBox: Box[Cat] = Box[Cat](Cat("Felix"))
  //  val myAnimalBox: Box[Animal] = myCatBox // this doesn't compile
  val myAnimalBox: Box[Animal] = Box[Animal](Cat("Felix"))
  val myAnimal: Animal = myAnimalBox.content
  //  println(myAnimalBox.content)
  myAnimalBox.content = Dog("Fido")
  //  println(myAnimalBox.content)


  class ImmutableBox[+A](val content: A)

  val catbox: ImmutableBox[Cat] = ImmutableBox[Cat](Cat("Felix"))
  val animalBox: ImmutableBox[Animal] = catbox // now this compiles


  def printAnimalNames(animals: List[Animal]): Unit =
    animals.foreach {
      animal => println(animal.name)
    }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  // prints: Whiskers, Tom
  printAnimalNames(cats)

  // prints: Fido, Rex
  printAnimalNames(dogs)

  abstract class Serializer[-A] {
    def serialize(a: A): String
  }

  val animalSerializer: Serializer[Animal] = new Serializer[Animal] {
    def serialize(animal: Animal): String = s"""{ "name": "${animal.name}" }"""
  }
  val catSerializer: Serializer[Cat] = animalSerializer
  println(catSerializer.serialize(Cat("Felix")))

  val bufInt: ListBuffer[Int] = ListBuffer[Int](1, 2, 3)
  //  val bufAny: ListBuffer[Any] = bufInt
  //  bufAny(0) = "Hello"
  val firstElem: Int = bufInt(0)
}
