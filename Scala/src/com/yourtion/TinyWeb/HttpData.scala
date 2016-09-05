package com.yourtion.TinyWeb

/**
  * Created by Yourtion on 9/5/16.
  */

case class HttpRequest(headers: Map[String, String] = Map(), body: String, path: String)
case class HttpResponse(body: String, responseCode: Integer)