package FunWithScala.IntersectionTypesCompoundTypes

object PlayGround {

  trait Cloneable extends java.lang.Cloneable {
    override def clone(): Cloneable = { // makes clone public
      super.clone().asInstanceOf[Cloneable]
    }
  }

  trait Resetable {
    def reset: Unit
  }

  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset
    cloned
  }
  //  Note that you can have more than two types: A with B with C with .... This means the same as thing as (...(A with B) with C) with ... )

}
