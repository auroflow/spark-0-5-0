val slf4jVersion = "1.6.1"
val HADOOP_VERSION = "0.20.205.0"

val shared = Seq(
  organization := "space.imbiansl",
  version := "0.5.0",
  scalaVersion := "2.10.7",
  scalacOptions := Seq(/*"-deprecation",*/ "-unchecked", "-optimize"), // -deprecation is too noisy due to usage of old Hadoop API, enable it once that's no longer an issue

  libraryDependencies ++= Seq(
    "org.eclipse.jetty" % "jetty-server" % "7.5.3.v20111011"
  )
)

lazy val root = (project in file("."))
  .aggregate(core, examples)
  .settings(
    name := "spark"
  )

lazy val core = (project in file("core"))
  .settings(
    shared,
    name := "spark-core",
    resolvers ++= Seq(
      "Typesafe Repository" at "https://repo.typesafe.com/typesafe/releases/",
      "JBoss Repository" at "https://repository.jboss.org/nexus/content/repositories/releases/",
      "Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
    ),
    libraryDependencies ++= Seq(
      "com.google.guava" % "guava" % "11.0.1",
      "log4j" % "log4j" % "1.2.16",
      "org.slf4j" % "slf4j-api" % slf4jVersion,
      "org.slf4j" % "slf4j-log4j12" % slf4jVersion,
      "com.ning" % "compress-lzf" % "0.8.4",
      "org.apache.hadoop" % "hadoop-core" % HADOOP_VERSION,
      "asm" % "asm-all" % "3.3.1",
      "com.google.protobuf" % "protobuf-java" % "2.4.1",
      "de.javakaffee" % "kryo-serializers" % "0.9",
      "org.jboss.netty" % "netty" % "3.2.6.Final",
      "it.unimi.dsi" % "fastutil" % "6.4.2",
      "org.apache.mesos" % "mesos" % "0.9.0-incubating",
      "org.scala-lang" % "scala-actors" % "2.10.7",
      "org.scalatest" %% "scalatest" % "1.9.2" % Test,
      "org.scalacheck" %% "scalacheck" % "1.9" % Test
    )
  )

lazy val examples = (project in file("examples"))
  .settings(
    shared,
    name := "spark-examples",
    libraryDependencies += "colt" % "colt" % "1.2.0"
  ).dependsOn(core)