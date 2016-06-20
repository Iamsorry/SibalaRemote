package idv.sorry

import akka.actor.{ Actor, ActorRef }

class Banker(val name: String) extends Actor {
    var players = Set[ActorRef]()
    
	def receive: Actor.Receive = {

		case Compete(playerName, playerPoint) =>
		    players += sender
			val bankerPoint = Dice.Roll()
			println(s"$name:[$bankerPoint] vs. $playerName:[$playerPoint]")
			if (playerPoint > bankerPoint)
				sender ! Sausage

		case PoliceWhistle =>
		    println("Police is coming!")
		    players.foreach(_ ! PoliceWhistle)
		    context.stop(self)

    }
}