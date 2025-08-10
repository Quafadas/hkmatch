import original.*
import scala.quoted.*

transparent inline def mac(
    inline dataType: api.TypeInferrer
) = ${ mac_impl('dataType) }

def mac_impl(dataType: Expr[api.TypeInferrer])(using
    q: Quotes
): Expr[String] =
    dataType match {
      case '{ TypeInferrer.Auto } =>
        Expr("Auto")
      // hint: import is from the wrong package. This commented out version would probably work.
      // case '{ api.TypeInferrer.FromTuple[t]() } =>
      case '{ TypeInferrer.FromTuple[t]() } =>
        Expr(s"FromTuple[${summon[Type[t]]}]")
    }
