package org.learningconcurrency.demo.chap03

import java.util.concurrent.atomic.AtomicReference

/**
  * Created by amos.zhou on 2016/2/1.
  */
class Entry(isDir: Boolean) {

  val state = new AtomicReference[State](new Idle())
}

sealed trait State

class Idle extends State

class Creating extends State

class Coping(val n: Int) extends State

class Deleting extends State