import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ApplicationRunnerSpec extends AnyWordSpec with Matchers {
  "applicationRunner" should {
    "not throw exception for valid file input" in {

      ApplicationRunner.main(Array("src/test/resources/test.txt"))
    }
  }
}