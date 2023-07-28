package spark.examples

import spark.SparkContext
import spark.SparkContext._

object ShuffleTest {

  def main(args: Array[String]): Unit = {
    if (args.length == 0) {
      System.err.println("Usage: ShuffleTest <host> <x>")
      System.exit(1)
    }

    val sc = new SparkContext(args(0), "shuffle text")

    val a = sc.parallelize(Seq(1, 2, 3, 4, 5, 6, 7, 8))
    val b = sc.parallelize(Seq(9, 10, 11, 12, 13, 14, 15, 16))

    val rdd = a.map(x => x * x).cartesian(b).reduceByKey(_ + _)
    val value = rdd.collect()

    println(value.mkString(", "))
  }
}
