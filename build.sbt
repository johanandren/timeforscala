import _root_.sbtrelease.ReleasePlugin.ReleaseKeys
import _root_.sbtrelease.ReleasePlugin._
import _root_.xerial.sbt.Sonatype._
import de.heikoseeberger.sbtheader.license.Apache2_0

scalaVersion := "2.11.8"
organization := "com.markatta"
description := "Simple Scala-y wrappers for the Java 8 time APIs"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % Test
)

headers := Map(
  "scala" -> Apache2_0("2015", "Johan Andrén")
)

// releasing
releaseSettings
sonatypeSettings
ReleaseKeys.crossBuild := true
crossScalaVersions := Seq("2.11.8", "2.12.0")
licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
homepage := Some(url("https://github.com/johanandren/timeforscala"))
publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := { _ => false }
publishTo := Some {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    "snapshots" at nexus + "content/repositories/snapshots"
  else
    "releases" at nexus + "service/local/staging/deploy/maven2"
}

pomExtra :=
  <scm>
    <url>git@github.com:johanandren/timeforscala.git</url>
    <connection>scm:git:git@github.com:johanandren/timeforscala.git</connection>
  </scm>
    <developers>
      <developer>
        <id>johanandren</id>
        <name>Johan Andrén</name>
        <email>johan@markatta.com</email>
        <url>https://markatta.com/johan/codemonkey</url>
      </developer>
    </developers>
