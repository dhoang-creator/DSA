package Queue

sealed trait Queue[+A]
case object Nil extends Queue[Nothing]
case class Cons[+A](head: A, tail: Queue[A]) extends Queue[A]

// Is the structure of a Queue simply the same as LinkedList but with different constraints?
object Queue {

  // Remember that the '*' indicates varargs
  def apply[A](as: A*): Queue[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
}
