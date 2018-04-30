package com.josedab.performance

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerformanceGetGreeting extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8080")
    .userAgentHeader("Gatling")

  val scn = scenario("GET /greeting")
    .repeat(100) {
      exec(http("GET /greeting").get("/greeting"))
    }

  setUp(
    scn.inject(atOnceUsers(1000))
  ).protocols(httpProtocol)
}