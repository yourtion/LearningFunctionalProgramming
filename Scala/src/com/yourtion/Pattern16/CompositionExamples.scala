package com.yourtion.Pattern16

/**
  * Created by Yourtion on 05/04/2017.
  */
object CompositionExamples {

  val appendA = (s: String) => s + "a"
  val appendB = (s: String) => s + "b"
  val appendC = (s: String) => s + "c"

  case class HttpRequest(
                          headers: Map[String, String],
                          payload: String,
                          principal: Option[String] = None)

  def checkAuthorization(request: HttpRequest) = {
    val authHeader = request.headers.get("Authorization")
    val mockPrincipal = authHeader match {
      case Some(headerValue) => Some("AUser")
      case _ => None
    }
    request.copy(principal = mockPrincipal)
  }
  def logFingerprint(request: HttpRequest) = {
    val fingerprint = request.headers.getOrElse("X-RequestFingerprint", "")
    println("FINGERPRINT=" + fingerprint)
    request
  }

  def composeFilters(filters: Seq[Function1[HttpRequest, HttpRequest]]) =
    filters.reduce {
      (allFilters, currentFilter) => allFilters compose currentFilter
    }

  def run(): Unit = {
    println("CompositionExamples :")
    val appendCBA = appendA compose appendB compose appendC
    println("appendA + appendB + appendC: " + appendCBA("z"))
    println()

    val filterChain = composeFilters(Vector(checkAuthorization, logFingerprint))
    val requestHeader = Map("Authorization" -> "Auth", "X-RequestFingerprint" -> "fingerprint")
    val request = HttpRequest(requestHeader, "body")
    println("FilterChain: " + filterChain(request))
  }
}
