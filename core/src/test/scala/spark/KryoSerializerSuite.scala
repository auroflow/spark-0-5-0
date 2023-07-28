package spark

import scala.collection.mutable
import scala.collection.immutable

import org.scalatest.FunSuite
import com.esotericsoftware.kryo._

import SparkContext._

class MyRegistrator extends KryoRegistrator {
    override def registerClasses(k: Kryo) {
      k.register(classOf[CaseClass])
      k.register(classOf[ClassWithNoArgConstructor])
      k.register(classOf[ClassWithoutNoArgConstructor])
      k.register(classOf[java.util.HashMap[_, _]])
    }
  }

case class CaseClass(i: Int, s: String) {}

  class ClassWithNoArgConstructor {
    var x: Int = 0
    override def equals(other: Any) = other match {
      case c: ClassWithNoArgConstructor => x == c.x
      case _ => false
    }
  }

  class ClassWithoutNoArgConstructor(val x: Int) {
    override def equals(other: Any) = other match {
      case c: ClassWithoutNoArgConstructor => x == c.x
      case _ => false
    }
  }
拍【