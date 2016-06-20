package idv.sorry

import akka.actor.{ Actor, ActorRef, ActorSystem, Props }

object SibalaClient {
	def main(args: Array[String]) {
		println("Sibala!")

		val casino = ActorSystem("street")
		val banker = casino.actorSelection("akka.tcp://bicycleServer@127.0.0.1:2552/user/banker")
		var players = List[ActorRef]()

		for (i <- 0 to 9) {
			players = casino.actorOf(Props(classOf[Player], s"adia$i", banker)) :: players
		}

		players.foreach(_ ! Play)

		Thread.sleep(1000 * 8)
		println("Sayonara")
        casino.terminate()
	}
}
