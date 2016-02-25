package org.learningconcurrency.demo.chap04

import java.io.File

import org.apache.commons.io.monitor.{FileAlterationListenerAdaptor, FileAlterationObserver, FileAlterationMonitor}

import scala.concurrent.{Promise, Future}
import scala.concurrent.ExecutionContext.Implicits.global


/**
  * Created by amos.zhou on 2016/2/25.
  */
object PromiseAdaptorForLegacy extends App {

  def fileCreated(directory: String): Future[String] = {
    val p = Promise[String]
    val fileMonitor = new FileAlterationMonitor(1000)
    val observer = new FileAlterationObserver(directory)
    val listener = new FileAlterationListenerAdaptor {
      override def onFileCreate(file: File): Unit = {
        try p.trySuccess(file.getName) finally fileMonitor.stop()
      }
    }

    observer.addListener(listener)
    fileMonitor.addObserver(observer)
    fileMonitor.start()
    p.future
  }

  fileCreated(".") foreach {
    case filename => log(s"Detected new file '$filename ")
  }
}