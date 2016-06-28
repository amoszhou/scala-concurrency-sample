import scala.math.Ordering

case class MyList[A](list: List[A]) {
  def sortBy1[B](f: A => B)(implicit ord: Ordering[B]): List[A] = list.sortBy(f)(ord)

  def sortby2[B: Ordering](f: A => B): List[A] = list.sortBy(f)(implicitly[Ordering[B]])
}

val list = MyList(List(1, 4, 3, 2, 5))

list sortBy1 (i => -i)

list sortby2 (i => -i)