package FunWithScala.TopLevelDefinitionsinPackages

import FunWithScala.TopLevelDefinitionsinPackages.gardening.fruits._

object PlayGround {
  object PrintPlanted {
    def main(args: Array[String]): Unit = {
      for (fruit <- planted) {
        showFruit(fruit)
      }
    }
  }

  @main def printPlanted(): Unit =
    for fruit <- planted do
      showFruit(fruit)

}
