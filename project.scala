//> using scala 3.7.2

// Hint: Another way of fixing this, is to import original.*
// import original.*
import api.*
import scala.quoted.*

@main def call =
  println("x")
  import scala.quoted.*
  val origTest = original.TypeInferrer.FromTuple[Int]()

  /** In user-space, you get a warning
  * the type test for original.TypeInferrer.FromTuple[Int] cannot be checked at runtime because its type arguments can't be determined from original.TypeInferrer
  *
  * which isn't terribly descriptive...
  */

  val hmmm = origTest match
    case TypeInferrer.Auto => println("yey") // simple case succcess - _should_ this work?
    case TypeInferrer.FromTuple[Int]() => println("???")

  // in macro land, this turns into a hard to track error.
  val x2 =
    mac(TypeInferrer.FromTuple[(Int, Int)]())
