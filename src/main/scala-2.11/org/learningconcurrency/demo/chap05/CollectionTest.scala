package org.learningconcurrency.demo.chap05

/**
  * Created by amos.zhou on 2016/2/26.
  */
object CollectionTest extends App{

  val result = (0 to 100000).filter(x=> x.toString == x.toString.reverse)

  println(result)

}
