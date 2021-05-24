package model

sealed trait Instruction

case object Left extends Instruction

case object Right extends Instruction

case object Move extends Instruction

object Instruction {
  def charToInstruction(instruction: Char): Instruction = instruction match {
    case 'G' => Left
    case 'D' => Right
    case 'A' => Move
    case _ => throw new UnsupportedOperationException("Invalid instruction")
  }

  def stringToString(instructions: String): String =
    if (instructions.matches("^[AGD]+$")) instructions
    else throw new UnsupportedOperationException("Invalid instructions input")
}

sealed trait Direction

case object North extends Direction

case object East extends Direction

case object West extends Direction

case object South extends Direction

object Direction {
  def charToDirection(direction: Char): Direction = direction match {
    case 'N' => North
    case 'E' => East
    case 'W' => West
    case 'S' => South
    case _ => throw new UnsupportedOperationException("Invalid direction")
  }
}

case class Position(x: Int, y: Int, direction: Direction)

object Position {
  def stringToPosition(positionString: String): Position = {
    if (positionString.length == 3) Position(positionString.charAt(0).toString.toInt,
      positionString.charAt(1).toString.toInt,
      Direction.charToDirection(positionString.charAt(2)))
    else throw new UnsupportedOperationException("Invalid position")
  }

  def printPosition(position: Position): Unit = {
    println(s"${position.x} ${position.y} ${position.direction}")
  }
}
