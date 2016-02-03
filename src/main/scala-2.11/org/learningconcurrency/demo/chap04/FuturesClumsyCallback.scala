package org.learningconcurrency.demo.chap04

import java.io._
import org.apache.commons.io.FileUtils._
import scala.collection.convert.decorateAsScala._
import scala.concurrent._
import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by amos.zhou on 2016/2/3.
  */
object FuturesClumsyCallback extends App {

  def blackListFile(name: String): Future[List[String]] = Future {
    val lines = Source.fromFile(name).getLines()
    lines.filter(x => !x.startsWith("#") && !x.isEmpty).toList
  }


  def findFiles(pattern: List[String]): List[String] = {
    val root = new File(".")
    for (f <- iterateFiles(root, null, true).asScala.toList;
         pat <- pattern;
         absPath = root.getCanonicalPath + File.separator + pat
         if (f.getCanonicalPath.contains(absPath))
    ) yield f.getCanonicalPath
  }


  def convert(xs: Seq[Option[Long]]): Option[Seq[Long]] = {
    xs.flatten(x => x) match {
      case seq if seq.length > 0 => Option(seq)
      case _ => None
    }
  }


  val seq: Seq[Option[Long]] = Seq(Option(0), Option(1), None, Option(3))

  println(convert(seq))


  val seq2: Seq[Option[Long]] = Seq(None, None, None, None)
  println(convert(seq2))
}
