import model._
import org.slf4j.LoggerFactory

import scala.collection.Seq

object InstructionProcessor {
  private lazy val logger = LoggerFactory.getLogger(this.getClass.getName)


  def processMovement(lines: Seq[String], grassSurface: GrassSurface): Mower = {
    val mower = Mower.build(lines.head, lines.last)
    InstructionProcessor.processInstructionList(mower, grassSurface)
  }

  private def processInstructionList(mower: Mower, grassSurface: GrassSurface): Mower = {
    var resultMower = mower

    while (resultMower.instructions.nonEmpty) {
      resultMower = processSingleInstruction(resultMower, grassSurface)
    }
    logger.info(s"final position of mower is ${resultMower}")
    resultMower.copy(instructions = "None")
  }

  private def processSingleInstruction(mower: Mower, grassSurface: GrassSurface): Mower = {
    val instructionString = mower.instructions.charAt(0)
    val instruction = Instruction.charToInstruction(instructionString)
    val remainingInstructions = mower.instructions.substring(1)
    mower.position.direction match {

      case North => {
        instruction match {
          case Right => {
            Mower(mower.position.copy(direction = East), remainingInstructions)
          }
          case Left => {
            Mower(mower.position.copy(direction = West), remainingInstructions)
          }
          case Move => {
            moveForward(mower, grassSurface, mower.position.x, mower.position.y + 1)
          }
        }
      }
      case West => {
        instruction match {
          case Right => {
            Mower(mower.position.copy(direction = North), remainingInstructions)
          }
          case Left => {
            Mower(mower.position.copy(direction = South), remainingInstructions)
          }
          case Move => {
            moveForward(mower, grassSurface, mower.position.x - 1, mower.position.y)
          }
        }
      }
      case East => {
        instruction match {
          case Right => {
            Mower(mower.position.copy(direction = South), remainingInstructions)
          }
          case Left => {
            Mower(mower.position.copy(direction = North), remainingInstructions)
          }
          case Move => {
            moveForward(mower, grassSurface, mower.position.x + 1, mower.position.y)
          }
        }
      }
      case South => {
        instruction match {
          case Right => {
            Mower(mower.position.copy(direction = West), remainingInstructions)
          }
          case Left => {
            Mower(mower.position.copy(direction = East), remainingInstructions)
          }
          case Move => {
            moveForward(mower, grassSurface, mower.position.x, mower.position.y - 1)
          }
        }
      }
    }
  }

  private def moveForward(mower: Mower, grassSurface: GrassSurface, xResult: Int, yResult: Int):Mower = {
    val newPosition = Position(xResult, yResult, mower.position.direction)
    if (mower.position.x > grassSurface.xMax || mower.position.y > grassSurface.yMax) {
      logger.info(s"mower new position is out of lawn surface")
      Mower(mower.position, mower.instructions.substring(1))
    }
    else Mower(newPosition, mower.instructions.substring(1))
  }
}
