
name := "spark-pp"

version := "0.1"

scalaVersion := "2.11.12"

val sparkDependencyScope = "compile"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.3.1" % sparkDependencyScope
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case PathList("datasets", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}