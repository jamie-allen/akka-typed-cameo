scalaVersion := "2.11.7"

name := "Akka Typed"

libraryDependencies ++= Seq(
          "com.typesafe.akka" % "akka-typed-experimental_2.11" % "2.4.0-RC1",
          "ch.qos.logback" % "logback-classic" % "1.1.2"
)
