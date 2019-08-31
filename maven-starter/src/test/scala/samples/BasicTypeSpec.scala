package samples

import org.scalatest.{FunSuite, Matchers}

class BasicTypeSpec extends FunSuite with Matchers {

  test("first test") {
    (1 + 1) shouldEqual (2)
    "Hello, " ++ "Scala!" shouldBe ("Hello, Scala!")

    println("Hello, Scala!".size)
    println(1 to 10)

    assert((1 + 2) == 1.+(2))
    assert(1.to(10) == (1 to 10))

    "Hello, Scala!".toUpperCase shouldBe "HELLO, SCALA!"
    -42.abs shouldBe 42


    println("16.toHexString:" + 16.toHexString)
    16.toHexString shouldBe "10"
    println("(0 to 10):" + (0 to 10))
    (0 to 10).contains(10) shouldBe true
    println("(0 until 10):" + (0 until 10))
    (0 until 10).contains(10) shouldBe false
    println("\"foo\".drop(1):"+ "foo".drop(1) )
    "foo".drop(1) shouldBe "oo"
    println("\"bar\".take(2):" + "bar".take(2))
    "bar".take(2) shouldBe "ba"
  }

}
