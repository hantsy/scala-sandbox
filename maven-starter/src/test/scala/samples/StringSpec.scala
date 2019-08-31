package samples

import org.scalatest.{FunSuite, Matchers}

class StringSpec extends FunSuite with Matchers {

  test("String interpolation") {
    def greet(name: String): String =
      s"Hello, $name!"

    greet("Scala") shouldBe "Hello, Scala!"
    greet("Functional Programming") shouldBe "Hello, Functional Programming!"

    def greet2( name:String) :String = s"Hello, ${name.toUpperCase()}!"
    greet2("Scala") shouldBe "Hello, SCALA!"
  }

}
