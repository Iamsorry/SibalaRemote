package idv.sorry

import akka.actor.{ Actor, ActorSelection }

class Player(val name: String, val banker: ActorSelection) extends Actor {
	def receive: Actor.Receive = {

		case Play =>
			val playerPoint = Dice.Roll()
			println(s"$name gets $playerPoint")
			banker ! Compete(name, playerPoint)

		case Sausage =>
			println(s"$name: oishi!")

		case PoliceWhistle =>
		    println(s"$name: Police is coming!")
		    context.stop(self)

	}
}