name := """webstore"""

version := "1.0-SNAPSHOT"
val playPort: Int = 8080
lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "3.8.1"
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
libraryDependencies += "org.mongodb" % "mongodb-driver-reactivestreams" % "5.1.0"
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
