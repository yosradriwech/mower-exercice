package model

import scala.language.implicitConversions

case class Mower(position: Position, instructions: String)

object Mower {

  def build(positionAndDirectionFromInput: String, instructionListFromInput: String): Mower = {
    try {
      val formattedPosDir = positionAndDirectionFromInput.replaceAll(" ", "")
      Mower(Position.stringToPosition(formattedPosDir), Instruction.stringToString(instructionListFromInput))

    } catch {
      case e: UnsupportedOperationException => throw e
      case _: Throwable => throw new Exception("Something went wrong when initializing inputs")
    }
  }
}
