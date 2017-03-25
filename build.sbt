name := """akkademy-db"""
organization := "com.akkademy-db"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.1"
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "com.typesafe.akka" %% "akka-actor" % "2.4.17",
  "com.typesafe.akka" %% "akka-testkit" % "2.4.17" % "test",
  "com.typesafe.akka" %% "akka-remote" % "2.4.17"
)

mappings in(Compile, packageBin) ~= {
  _.filterNot { case (_, name) =>
    Seq("application.conf").contains(name)
  }
}
