name := "deliberationv1"

version := "1.0"

lazy val `deliberationv1` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  