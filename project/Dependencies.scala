import sbt._

object Dependencies {
  import Versions._
  val slf4jDependencies = Seq(
    "org.slf4j" % "slf4j-api" % slf4jVersion
    , "org.slf4j" % "slf4j-log4j12" % slf4jVersion
    , "org.apache.logging.log4j" % "log4j-core" % "2.13.3"
  )

  val testDependencies = Seq(
    "org.scalactic" %% "scalactic" % "3.2.7",
    "org.scalatest" %% "scalatest" % "3.2.7" % "test"
  )
}
