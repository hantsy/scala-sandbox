package samples

import org.scalatest.{FunSuite, Matchers}

class OptionSpec extends FunSuite with Matchers {

  test("Option") {
    //map
    Some(1).map(x => x + 1) shouldBe Some(2)
    None.map((x: Int) => x + 1) shouldBe None
    Option(1).map(x => x + 1) shouldBe Option(2)

    //filter
    Some(1).filter(x => x % 2 == 0) shouldBe None
    Some(2).filter(x => x % 2 == 0) shouldBe Some(2)
    Option(2).filter(x => x % 2 == 0) shouldBe Option(2)

    //flatMap
    Some(1).flatMap(x => Some(x + 1)) shouldBe Some(2)
    None.flatMap((x: Int) => Some(x + 1)) shouldBe None
    Option(1).flatMap(x => Some(x + 1)) shouldBe Option(2)
  }


}
