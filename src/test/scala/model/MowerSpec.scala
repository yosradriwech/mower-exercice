package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MowerSpec extends AnyWordSpec with Matchers {
  "build" should {
    "return Mower if string input is valid" in {

      val expected = Mower(Position(1, 2, North), "GAGAGAGAA")
      Mower.build("1 2 N", "GAGAGAGAA") shouldBe expected
    }
  }
  "throw exception Something went wrong when initializing inputs" in {

    val expected = "Something went wrong when initializing inputs"
    val thrown = intercept[Exception] {
      Mower.build("h", "GG")
    }
    assert(thrown.getMessage === expected)
  }
  "throw invalid instructions input exception" in {

    val expected = "Invalid instructions input"
    val thrown = intercept[Exception] {
      Mower.build("1 2 N", "F")
    }
    assert(thrown.getMessage === expected)
  }
  "throw Invalid direction" in {

    val expected = "Invalid direction"
    val thrown = intercept[Exception] {
      Mower.build("1 2 K", "G")
    }
    assert(thrown.getMessage === expected)
  }
  "throw Invalid position " in {

    val expected = "Invalid position"
    val thrown = intercept[Exception] {
      Mower.build("1 h N", "G")
    }
    assert(thrown.getMessage === expected)
  }
}