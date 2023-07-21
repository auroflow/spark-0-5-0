# Spark Core 0.5.0

This is the source code of Spark Core 0.5.0 with Spark examples, modified for running on JDK 1.8 and Scala 2.10.7. This
code is solely for pedagogical purposes.

## Build

JDK 1.8 is required to build this project.

First, add the following repository to `~/.sbt/repositories`, which will help find sbt 0.13.18:

```bash
typesafe: https://repo.lightbend.com/typesafe/ivy-releases/, [organization]/[module]/(scala_[scalaVersion]/)(sbt_[sbtVersion]/)[revision]/[type]s/[artifact](-[classifier]).[ext], bootOnly
```

Configure the correct `%JAVA_HOME%` environment variable, and add `sbt` to PATH. Then, run the following command to build the project:

```bash
sbt compile
```
