package samples

import org.scalatest.{FunSuite, Matchers}

import scala.annotation.tailrec

class FuncSpec extends FunSuite with Matchers {

  test("functions") {

    def factorial(n: Int): Int =
      if (n == 1) 1
      else factorial(n - 1) * n

    factorial(3) shouldBe 6
    factorial(4) shouldBe 24
  }

  test("tail recursion") {
    def factorial(n: Int): Int = {
      @tailrec
      def iter(x: Int, result: Int): Int =
        if (x == 1) result
        else iter(x - 1, result * x)

      iter(n, 1)
    }

    factorial(3) shouldBe 6
    factorial(4) shouldBe 24

  }

  test("higher order function") {
    def sum(f: Int => Int, a: Int, b: Int): Int = {
      def loop(x: Int, acc: Int): Int = {
        if (x > b) acc
        else loop(x + 1, acc + f(x))
      }

      loop(a, 0)
    }

    sum(x => x, 1, 10) shouldBe 55
  }

}
