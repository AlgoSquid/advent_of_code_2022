val scala3Version = "3.2.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "First Scala project with Advent of Code",
    scalaVersion := scala3Version,
  )
