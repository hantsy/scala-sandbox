package samples

import org.scalatest.{FunSuite, Matchers}

class CaseClassSpec extends FunSuite with Matchers {

  test("case class") {

    case class Note(name: String, duration: String, octave: Int)

    val c3 = Note("C", "Quarter", 3)
    c3.name shouldBe "C"
    c3.duration shouldBe "Quarter"
    c3.octave shouldBe 3
  }

  test("equals") {
    case class Note(name: String, duration: String, octave: Int)
    val c3 = Note("C", "Quarter", 3)
    val otherC3 = Note("C", "Quarter", 3)
    val f3 = Note("F", "Quarter", 3)
    (c3 == otherC3) shouldBe true
    (c3 == f3) shouldBe false
  }

  test(" trait") {
    sealed trait Duration
    case object Whole extends Duration
    case object Half extends Duration
    case object Quarter extends Duration

    def fractionOfWhole(duration: Duration): Double =
      duration match {
        case Whole => 1.0
        case Half => 0.5
        case Quarter => 0.25
      }

    fractionOfWhole(Half) shouldBe 0.5
    fractionOfWhole(Quarter) shouldBe 0.25
  }

}
