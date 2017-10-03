scalaVersion := "2.11.11"
organization := "com.markatta"
description := "Simple Scala-y wrappers for the Java 8 time APIs"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.4" % Test
)

releaseCrossBuild := true

crossScalaVersions := Seq("2.11.11", "2.12.3")

organizationName := "Johan Andrén"
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
