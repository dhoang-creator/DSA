package Tree

sealed trait Tree[+T]
case class Leaf[T](value: T) extends Tree[T]
case class Branch[T](left: Tree[T], right: Tree[T]) extends Tree[T]

object Tree extends App {
  val tree: Tree[Int] = Branch(Leaf(0), Leaf(1))

  def asList[T](tree: Tree[T]): List[T] = tree match {
    case Leaf(a) => List(a)
    case Branch(left, right) => asList(left) ::: asList(right)
  }
}
