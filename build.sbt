name := """webstore"""

version := "1.0-SNAPSHOT"
val playPort: Int = 8080
lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "3.8.1"
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2" % Test

libraryDependencies += "org.mongodb" % "mongodb-driver-sync" % "5.6.4"
// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
