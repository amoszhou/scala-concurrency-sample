package org.learningconcurrency.demo.chap03

import java.util.concurrent.atomic.AtomicReference

/**
  * Created by amos.zhou on 2016/2/1.
  */
class Entry(isDir: Boolean) {

  val state = new AtomicReference[State](new Idle())

  private def prepareForDelete(entry: Entry): Boolean = {
    val s0 = entry.state.get()
    s0 match {
      case i: Idle =>
        if (entry.state.compareAndSet(s0, new Deleting)) true
        else prepareForDelete(entry)

      case c: Creating => false
      case c: Coping => false
      case d: Deleting => false
    }
  }
}

sealed trait State

class Idle extends State

class Creating extends State

class Coping(val n: Int) extends State

class Deleting extends State