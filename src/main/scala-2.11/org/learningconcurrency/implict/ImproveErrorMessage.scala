package org.learningconcurrency.implict

/**
  * Created by amos.zhou on 16:13.
  */
object ImproveErrorMessage extends App {

  List(1, 2, 3, 4).map[Int, ListWrapper](_ * 2)
}


case class ListWrapper(list: List[Int])

