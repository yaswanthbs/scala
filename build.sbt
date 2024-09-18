ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test

lazy val root = (project in file("."))
  .settings(
    name := "exercise"
  )
