package samples

import org.scalatest.{FunSuite, Matchers}

class ListSpec extends FunSuite with Matchers {

  test("::") {
    val cond: (Int, Int) => Boolean = _ < _

    def insert(x: Int, xs: List[Int]): List[Int] =
      xs match {
        case List() => x :: Nil
        case y :: ys =>
          if (cond(x, y)) x :: y :: ys
          else y :: insert(x, ys)
      }

    insert(2, 1 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
    insert(1, 2 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
    insert(3, 1 :: 2 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
  }

}
