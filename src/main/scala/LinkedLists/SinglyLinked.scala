package LinkedLists

sealed trait SinglyLinked[+A]
case object Nil extends SinglyLinked[Nothing]
case class Cons[+A](head: A, tail: SinglyLinked[A]) extends SinglyLinked[A]

object SinglyLinked {

  def sum(ints: SinglyLinked[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: SinglyLinked[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): SinglyLinked[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  def foldRight[A, B](as: SinglyLinked[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x,xs) => f(x, foldRight(xs,z)(f))
    }

  def sum_v2(ns: SinglyLinked[Int]) =
    foldRight(ns, 0)((x, y) => x + y)

  def product_v2(ns: SinglyLinked[Double]) =
    foldRight(ns, 1.0)(_ * _)
}
