package FunWithScala.Classes

class Point2:
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x: Int = _x

  def x_=(newValue: Int): Unit =
    if newValue < bound then
      _x = newValue
    else
      printWarning()

  def y: Int = _y

  def y_=(newValue: Int): Unit =
    if newValue < bound then
      _y = newValue
    else
      printWarning()

  private def printWarning(): Unit =
    println("WARNING: Out of bounds")

  override def toString: String =
    s"$_x, $_y"
  
end Point2