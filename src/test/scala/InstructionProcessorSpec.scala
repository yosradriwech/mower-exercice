import model.{East, GrassSurface, Mower, Position}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class InstructionProcessorSpec extends AnyWordSpec with Matchers {
  "processMovement" should {
    "return a valid Mower" in {
      val expected = Mower(Position(3, 3, East), "")
      InstructionProcessor.processMovement(Seq("1 2 N", "GAGAGAGAA"), GrassSurface(5, 5))
    }
  }
}