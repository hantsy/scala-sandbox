package com.example

object TimerAnonymous {

  def onePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread sleep 1000
    }
  }

  def main(args: Array[String]): Unit = {
    onePerSecond(
      () => {
        println("time flies like an arrow...")
      }
    )
  }
}