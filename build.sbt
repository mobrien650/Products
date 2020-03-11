name := "Product"

version := "0.1"

scalaVersion := "2.12.10"

val httpVersion = "20.1.0"
val logbackVersion = "1.2.3"
val scalaTestVersion = "3.1.1"

libraryDependencies ++= Seq(
  // Server
  "com.twitter" %% "finatra-http" % httpVersion,

  // Logging
  "ch.qos.logback" % "logback-classic" % logbackVersion,

  // Tests
  "com.twitter" %% "inject-server" % httpVersion % "test" classifier "tests",
  "com.twitter" %% "inject-app" % httpVersion % "test" classifier "tests",
  "com.twitter" %% "inject-core" % httpVersion % "test" classifier "tests",
  "com.twitter" %% "inject-modules" % httpVersion % "test" classifier "tests",

  "org.scalactic" %% "scalactic" % scalaTestVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % "test",
)

