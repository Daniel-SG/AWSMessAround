name := "s3-trigger-slack-app-scala"

version := "0.1"

scalaVersion := "2.11.12"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

lazy val root = (project in file(".")).
  settings(
    name := "lambda-demo",
    version := "1.0",
    scalaVersion := "2.11.4",
    retrieveManaged := true,
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-core" % "1.0.0",
    libraryDependencies += "com.amazonaws" % "aws-lambda-java-events" % "1.0.0" ,
    libraryDependencies += "net.liftweb" %% "lift-json" % "2.6+",
    libraryDependencies +=  "org.scalaj" %% "scalaj-http" % "2.4.2"
  )

assemblyMergeStrategy in assembly := {

  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}