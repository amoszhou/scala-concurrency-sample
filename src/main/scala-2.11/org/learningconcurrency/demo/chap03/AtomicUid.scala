package org.learningconcurrency.demo.chap03

/**
  * Created by amos.zhou on 2016/2/1.
  */
object AtomicUid extends App {


  import java.util.concurrent.atomic._

  private val uid = new AtomicLong(0L)

  def getUniqueId: Long = uid.incrementAndGet()


    execute {
      log(s"Uid asynchronously: ${getUniqueId}")
    }
    log(s"Got a unique id: ${getUniqueId}")

}
