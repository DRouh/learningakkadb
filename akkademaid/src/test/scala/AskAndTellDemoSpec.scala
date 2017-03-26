import akka.actor.{ActorSystem, Props}
import akka.testkit.TestProbe
import akka.util.Timeout
import com.akkademy._
import org.scalatest.{FunSpec, Matchers}
import scala.concurrent.duration._

class AskAndTellDemoSpec extends FunSpec with Matchers {
  implicit val system = ActorSystem("test")
  implicit val timeout = Timeout(10 seconds)

  describe("ask demo") {
    val cacheProbe = TestProbe()
    val httpClientProbe = TestProbe()
    val articleParseActor = system.actorOf(Props[ParsingActor])
    val askDemoActor = system.actorOf(
      Props(classOf[AskDemoArticleParser],
        cacheProbe.ref.path.toString,
        httpClientProbe.ref.path.toString,
        articleParseActor.path.toString,
        timeout)
    )

    describe("tell demo") {
      val cacheProbe = TestProbe()
      val httpClientProbe = TestProbe()
      val articleParseActor = system.actorOf(Props[ParsingActor])
      val tellDemoActor = system.actorOf(
        Props(classOf[TellDemoArticleParser],
          cacheProbe.ref.path.toString,
          httpClientProbe.ref.path.toString,
          articleParseActor.path.toString,
          timeout)
      )
    }
  }
}