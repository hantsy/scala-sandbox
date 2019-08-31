package samples

import org.scalatest.{FunSuite, Matchers}

class DefSpec extends FunSuite with Matchers {

  test("Evaluations and definitions") {
    def square(x: Double) = x * x

    square(3.0) shouldBe 9.0

    def area(radius: Double): Double = 3.14159 * square(radius)

    area(10) shouldBe 314.159

    def triangleArea(base: Double, height: Double): Double =
      base * height / 2

    triangleArea(3, 4) shouldBe 6.0
    triangleArea(5, 6) shouldBe 15.0

    def factorial(n: Int): Int =
      if (n == 1) 1
      else factorial(n - 1) * n

    factorial(3) shouldBe 6
    factorial(4) shouldBe 24
  }

}
