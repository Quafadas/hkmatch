//> using scala 3.7.2

// Hint: Another way of fixing this, is to import original.*
// import original.*
import api.*
import scala.quoted.*

@main def call =
  println("x")
  import scala.quoted.*
  val x1 = mac(TypeInferrer.Auto)
  val x2 =
    mac(TypeInferrer.FromTuple[(Int, Int)]())
  println(x1)
  println(x2)
