package com.example

object Timer {
  def onePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def timeFiles(): Unit = {
    println("time flies like an arrow...")
  }

  def main(args: Array[String]): Unit = {
    onePerSecond(timeFiles)
  }
}
