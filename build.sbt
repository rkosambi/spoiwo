lazy val pomDetails = <url>https://github.com/norbert-radyk/spoiwo/</url>
  <licenses>
    <license>
      <name>MIT-License</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/norbert-radyk/spoiwo</url>
    <developerConnection>scm:git:git@github.com:norbert-radyk/spoiwo.git</developerConnection>
    <connection>scm:git:git@github.com:norbert-radyk/spoiwo.git</connection>
  </scm>
  <developers>
    <developer>
      <id>rahul.kosambi</id>
      <name>Rahul Kosambi</name>
      <email>rahul.kosambi@flipkart.com</email>
    </developer>
  </developers>

lazy val commonSettings = Seq(
  organization := "com.norbitltd",
  scalaVersion := "2.11.8",
  publishMavenStyle := true,
  publishArtifact in Test := false,
  publishTo := {
    val flipkart = "http://artifactory.nm.flipkart.com:8081/artifactory"
    if (isSnapshot.value)
      Some("snapshots" at flipkart + "/libs-snapshot")
    else
      Some("releases"  at flipkart + "/libs-snapshot")
  },
  pomExtra := pomDetails,
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
    version := "1.2.0"
  )

lazy val examples = (project in file("examples"))
  .dependsOn(spoiwo)
  .settings(commonSettings : _*)
  .settings(
    name := "spoiwo-examples",
    version := "1.2.0"
  )
