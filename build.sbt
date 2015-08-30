import de.heikoseeberger.sbtheader.license.Apache2_0

scalaVersion := "2.11.7"
version := "1.0-SNAPSHOT"
organization := "com.markatta"
description := "Simple Scala-y wrappers for the Java 8 time APIs"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

headers := Map(
  "scala" -> Apache2_0("2015", "Johan Andrén")
)