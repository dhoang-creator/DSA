package LinkedLists

sealed trait DoublyLinked[+A]
case object Nil extends DoublyLinked[Nothing]
case class Cons[+A](head: A, tail: DoublyLinked[A]) extends DoublyLinked[A]

object DoublyLinked {

}