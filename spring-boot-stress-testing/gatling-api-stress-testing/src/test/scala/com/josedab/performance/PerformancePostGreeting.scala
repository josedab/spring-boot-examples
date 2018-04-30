package com.josedab.performance

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerformancePostGreeting extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8080")
    .userAgentHeader("Gatling")

  val scn = scenario("POST /greeting")
    .repeat(100) {
      exec(http("POST /greeting").post("/greeting").body(StringBody("""{"id":"1234", "content": "gatling test"}""")))
    }

  setUp(
    scn.inject(atOnceUsers(1000))
  ).protocols(httpProtocol)
}