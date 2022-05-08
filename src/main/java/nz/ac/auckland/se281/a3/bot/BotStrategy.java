package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {
	Action decideAction(Hand hand); // action (hold or hit) to make

	int makeABet(); // how many chips to bet
}