package samples

import org.scalatest.{FunSuite, Matchers}

class EitherSpec extends FunSuite with Matchers {



  test("Either") {
    def triple(x: Int): Int = 3 * x

    def tripleEither(x: Either[String, Int]): Either[String, Int] =
      x.map(triple)

    tripleEither(Right(1)) shouldBe Right(3)
    tripleEither(Left("not a number")) shouldBe Left("not a number")
  }

  test("Type alias: Either"){
    type Result = Either[String, (Int, Int)]
    def divide(dividend: Int, divisor: Int): Result =
      if (divisor == 0) Left("Division by zero")
      else Right((dividend / divisor, dividend % divisor))
    divide(6, 4) shouldBe Right((1, 2))
    divide(2, 0) shouldBe Left("Division by zero")
    divide(8, 4) shouldBe Right(2, 0)
  }

}
