package org.learningconcurrency.demo.chap06

import scala.util.Random

/**
  * Created by amos.zhou on 15:55.
  */
object Test extends App {

  val randomInt = new Random().nextInt(10)

  randomInt match {
    case 7 => println("you are lucky")
    case otherNumber@_ => println(s"not lucky .$otherNumber")
  }


}
