lazy val commonSettings = Seq(
  organization := "com.norbitltd",
  scalaVersion := "2.11.8",
  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishTo in ThisBuild <<= version { (v: String) =>
    val flipkartArtifactory = "http://artifactory.nm.flipkart.com:8081/artifactory/"
    if (v.trim.endsWith("SNAPSHOT"))
      Some("snapshots" at flipkartArtifactory + "libs-snapshots-local")
    else
      Some("releases" at flipkartArtifactory + "libs-release-local")
  },
    publishArtifact in (Compile, packageDoc) in ThisBuild := false,
  libraryDependencies ++= Seq(
    "org.scala-lang.modules" %% "scala-xml"         % "1.0.5",
    "org.apache.poi"         %  "poi"               % "3.14",
    "org.apache.poi"         %  "poi-ooxml"         % "3.14",
    "joda-time"              %  "joda-time"         % "2.9",
    "org.joda"               %  "joda-convert"      % "1.8.1",
    "org.scalatest"          %% "scalatest"         % "2.2.6"   % "test"
  )
)

lazy val spoiwo = (project in file("."))
  .settings(commonSettings : _*)
  .settings(
    name := "spoiwo",
    version := "1.5.0"
  )

lazy val examples = (project in file("examples"))
  .dependsOn(spoiwo)
  .settings(commonSettings : _*)
  .settings(
    name := "spoiwo-examples",
    version := "1.5.0"
  )
