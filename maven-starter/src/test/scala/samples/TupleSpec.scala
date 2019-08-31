package samples

import org.scalatest.{FunSuite, Matchers}

class TupleSpec extends FunSuite with Matchers {

  test("tuple") {
    def pair(i: Int, s: String): (Int, String) = (i, s)

    pair(42, "foo") shouldBe(42, "foo")
    pair(0, "bar") shouldBe(0, "bar")
  }

  test(" tuple pattern") {
    val is: (Int, String) = (42, "foo")

    is match {
      case (i, s) =>
        i shouldBe 42
        s shouldBe "foo"
    }

    val (i, s) = is
    i shouldBe 42
    s shouldBe "foo"

  }


  test(" tuple and member access") {
    val is: (Int, String) = (42, "foo")

    is._1 shouldBe 42
    is._2 shouldBe "foo"
  }

}
