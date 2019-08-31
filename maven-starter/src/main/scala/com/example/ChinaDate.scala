package com.example

import java.text.DateFormat._
import java.util.{Date, Locale}

object ChinaDate {
  def main(args: Array[String]): Unit = {
    val now= new Date()
    val df = getDateInstance(LONG, Locale.CHINA)
    println(df format now)
  }
}
