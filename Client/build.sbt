name := """akkademy-db-client"""
version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.17",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.17" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.akkademy-db" %% "akkademy-db" % "0.0.1-SNAPSHOT"
)