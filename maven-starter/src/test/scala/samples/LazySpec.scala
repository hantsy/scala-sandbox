package samples

import org.scalatest.{FunSuite, Matchers}

class LazySpec extends FunSuite with Matchers {

  test("lazy"){
    val builder = new StringBuilder

    val x = { builder += 'x'; 1 }
    lazy val y = { builder += 'y'; 2 }
    def z = { builder += 'z'; 3 }

    z + y + x + z + y + x

    println(builder.result())
    //builder.result() shouldBe

  }
  test("methods on streams"){
    var rec = 0
    def streamRange(lo: Int, hi: Int): LazyList[Int] = {
      rec = rec + 1
      if (lo >= hi) LazyList.empty
      else LazyList.cons(lo, streamRange(lo + 1, hi))
    }
    streamRange(1, 10).take(3).toList
    println(rec)
    rec shouldBe 4
  }
}