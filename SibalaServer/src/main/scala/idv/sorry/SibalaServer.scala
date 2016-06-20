package idv.sorry

import akka.actor.{ Actor, ActorRef, ActorSystem, Props }

object SibalaServer {
	def main(args: Array[String]) {
		println("Sibala!")

		val casino = ActorSystem("bicycleServer")
		val banker = casino.actorOf(Props(classOf[Banker], "abeh"), name = "banker")

		Thread.sleep(1000 * 4)
		banker ! PoliceWhistle

		Thread.sleep(1000 * 4)
		println("Sayonara")
        casino.terminate()
	}
}
