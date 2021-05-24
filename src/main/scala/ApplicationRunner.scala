
import model.GrassSurface._
import model.{Mower, Position}
import org.slf4j.LoggerFactory

import scala.collection._
import scala.io.{BufferedSource, Source}

object ApplicationRunner extends App {
  private lazy val logger = LoggerFactory.getLogger(this.getClass.getName)
  if (args.length == 1) {
    logger.info(s"start the mower movement process")
    val file = args(0)
    val sourceFile: BufferedSource = Source.fromFile(file)
    var resultMowers = Seq[Mower]()
    val grassSurface = build(sourceFile.getLines.next())
    for (linePairs <- sourceFile.getLines.sliding(2, 2)) {
      val mowerPosition = InstructionProcessor.processMovement(linePairs, grassSurface)
      resultMowers = resultMowers.appended(mowerPosition)
    }
    Source.fromFile(file).close()
    resultMowers.foreach(mower => Position.printPosition(mower.position))
  } else logger.info("please provide a valid file path")
}
