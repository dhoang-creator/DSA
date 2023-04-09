package Tree

sealed trait NArrayTree[+A]
case class Leaf[A](value: A) extends NArrayTree[A]
case class Branch[A](left: NArrayTree[A], right: NArrayTree[A]) extends NArrayTree[A]
