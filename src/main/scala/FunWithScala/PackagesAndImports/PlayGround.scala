package FunWithScala.PackagesAndImports

object PlayGround {

  def sqrtplus1(x: Int) = {
    import scala.math.sqrt
    sqrt(x) + 1.0
  }
}
