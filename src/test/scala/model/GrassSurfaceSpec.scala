package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GrassSurfaceSpec extends AnyWordSpec with Matchers {
  "build" should {
    "return GrassSurface if string input is valid" in {

      val expected = GrassSurface(5, 5)
      GrassSurface.build("55") shouldBe expected
    }
  }
  "throw exception Invalid tuple" in {

    val expected = "Invalid tuple"
    val thrown = intercept[Exception] {
      GrassSurface.build("yY;")
    }
    assert(thrown.getMessage === expected)
  }
}