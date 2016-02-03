package org.learningconcurrency.demo.chap04

import scala.concurrent.Future
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by amos.zhou on 2016/2/3.
  */
object FuturesCallbacks extends App {

  def getUrlSpecification(): Future[List[String]] = Future {
    val url = "http://www.w3.org/Addressing/URL/url-spec.txt"
    val f = Source.fromURL(url)
    try
      f.getLines().toList
    finally
      f.close()
  }

  def find(lines: List[String], keyword: String): String = {
    lines.zipWithIndex collect {
      case (line, n) if line.contains(keyword) => (n, line)
    } mkString ("\n")
  }

  val urlSpec = getUrlSpecification()
  urlSpec.onSuccess {
    case lines => {
      val result = find(lines, "telnet")
      print(result)
    }
  }
  urlSpec.onFailure {
    case ex => println(ex.getMessage)
  }

  Thread.sleep(5000)

}
