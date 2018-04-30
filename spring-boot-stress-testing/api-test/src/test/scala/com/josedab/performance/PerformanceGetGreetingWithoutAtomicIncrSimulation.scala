package com.josedab.performance

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerformanceGetGreetingWithoutAtomicIncrSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:8080")
    .userAgentHeader("Gatling")

  val scn = scenario("GET /greetingWithoutCounter without Atomic Integer lock")
    .repeat(100) {
      exec(http("GET /greetingWithoutCounter").get("/greetingWithoutCounter"))
    }

  setUp(
    scn.inject(atOnceUsers(1000))
  ).protocols(httpProtocol)
}