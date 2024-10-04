package FunWithScala.TopLevelDefinitionsinPackages.gardening.fruits

case class Fruit(name: String, color: String)

object Apple extends Fruit("Apple", "green")

object Plum extends Fruit("Plum", "blue")

object Banana extends Fruit("Banana", "yellow")

val planted = List(Apple, Plum, Banana)
def showFruit(fruit: Fruit): Unit =
  println(s"${fruit.name}s are ${fruit.color}")

package object fruits {
  val planted = List(Apple, Plum, Banana)

  def showFruit(fruit: Fruit): Unit = {
    println(s"${fruit.name}s are ${fruit.color}")
  }
}

//private object FruitAliases extends FruitAliases
//private object FruitHelpers extends FruitHelpers
//
//export FruitHelpers.*, FruitAliases.*