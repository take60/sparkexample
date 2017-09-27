import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Inclement_num",
    libraryDependencies ++= Seq(scalaTest % Test,"org.apache.spark" %% "spark-core" % "2.2.0","org.apache.spark" %% "spark-streaming" % "2.2.0")
  )
