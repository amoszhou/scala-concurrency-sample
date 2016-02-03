package org.learningconcurrency.demo.chap04

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.io.Source

/**
  * Created by amos.zhou on 2016/2/2.
  */
object FuturesDataType extends App {

  val buildFile: Future[String] = Future {
    val f = Source.fromFile("build.sbt")
    try {
      f.getLines().mkString("\n")
    } finally {
      f.close()
    }
  }

  log(s"Start reading build.sbt async")
  log(s" status: ${buildFile.isCompleted}")
  Thread.sleep(250)
  log(s" status: ${buildFile.isCompleted}")
  log(s"value : ${buildFile.value}")
}
