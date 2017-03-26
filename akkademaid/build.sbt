name := """akkademaid"""
version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.syncthemall" % "boilerpipe" % "1.2.2",
  "com.akkademy-db" %% "akkademy-db" % "0.0.1-SNAPSHOT",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.typesafe.akka" %% "akka-actor" % "2.4.17",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.17" % "test"
)
