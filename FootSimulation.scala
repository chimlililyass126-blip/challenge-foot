package football

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class FootSimulation extends Simulation {

  val httpProtocol = http
    // On cible ton site de foot qui tourne dans Docker
    .baseUrl("http://host.docker.internal:8082") 
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

  val scn = scenario("Test Charge Foot")
    .exec(http("Accession Page Accueil").get("/"))

  // On lance 10 utilisateurs simultanés d'un coup
  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpProtocol)
}