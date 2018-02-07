import io.gatling.core.Predef._
import io.gatling.http.Predef._
import java.sql.{Connection, DriverManager}
import scala.language.dynamics
import java.util.Calendar
import java.text.SimpleDateFormat
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration.SECONDS

class LoadTest extends Simulation {
  val httpProtocol = http.baseURL(LoadTest.baseUrl).inferHtmlResources()

  val feeder = (for (i <- 0 to LoadTest.iterations) yield {
    Map("id" -> i)
  })

  val iterations = LoadTest.iterations / LoadTest.concurrentUsers

  val scn = scenario("get hello").repeat(iterations) {
    feed(feeder)
      .exec(http("get hello")
        .get(LoadTest.baseUrl)
        .check(status.is(200)))
  }
  setUp(
    scn.inject(atOnceUsers(LoadTest.concurrentUsers)).protocols(httpProtocol)
  )
}

object LoadTest {
  val baseUrl = scala.sys.env("BASE_URL")
  val iterations = scala.sys.env("ITERATIONS").toInt
  val concurrentUsers=scala.sys.env("CONCURRENT_USERS").toInt
}
