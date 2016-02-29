package org.learningconcurrency.demo.chap05

import scala.collection.GenSeq
import scala.concurrent.{Await, Future}
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by amos.zhou on 2016/2/29.
  */
object ParHtmlSearch extends App {


  /**
    * 因为URL变更，这个例子无打印。
    * @return
    */
  def getHtmlSpec() = Future {
    val url = "http://www.w3.org/MarkUp/htmlspec/html-spec.txt";
    val specSrc = Source.fromURL(url)
    try specSrc.getLines().toArray finally specSrc.close()
  }

  getHtmlSpec() foreach { case specDoc =>
    def search(d: GenSeq[String]): Double = timed {
      d.indexWhere(line => line.matches(".*TEXTAREA.*"))
    }
    val seqTime = search(specDoc)
    log(s"Sequential time $seqTime ms")
    val partime = search(specDoc.par)
    log(s"Parallel time $partime ms")

  }

}
