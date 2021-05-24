package model

import org.slf4j.LoggerFactory

case class GrassSurface(xMax: Int, yMax: Int)

object GrassSurface {
  private lazy val logger = LoggerFactory.getLogger(this.getClass.getName)

  def build(grassSurface: String): GrassSurface = {
    try {
      val formattedInput = grassSurface.replaceAll(" ", "")
      val tuple = stringToTuple(formattedInput)
      logger.info(s"string successfully formatted to GrassSurface object")
      GrassSurface(tuple._1, tuple._2)

    } catch {
      case e: UnsupportedOperationException => throw e
      case _: Throwable => throw new Exception("Enable to extract grassSurface : invalid String Input")
    }
  }

  private def stringToTuple(stringToConvert: String): (Int, Int) =
    if ((stringToConvert.length == 2) && stringToConvert.forall(car => car.isDigit)) {
      (stringToConvert(0).toString.toInt, stringToConvert(1).toString.toInt)
    }
    else throw new UnsupportedOperationException("Invalid tuple")
}
