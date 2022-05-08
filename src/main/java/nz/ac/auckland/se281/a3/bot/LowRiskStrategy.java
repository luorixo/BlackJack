package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LowRiskStrategy implements BotStrategy {

	/**
	 * Decides on action based on the bot's current score only holds if score is at
	 * least 17
	 * 
	 * @return the action to take (HOLD or HIT)
	 */
	@Override
	public Action decideAction(Hand hand) {
		int currentScore = hand.getScore(); // gets current score

		// if score is 17 or greater holds, otherwise hits
		if (currentScore >= 17) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	/**
	 * Makes random bet from 10 to 50 (inclusive) Made by pseudo-random no.
	 * generation
	 * 
	 * @return the random bet
	 */
	@Override
	public int makeABet() {
		Random randomInt = new Random();

		int randomBet = (randomInt.nextInt(41)) + 10; // generates random no. (bet) from 10-50 (inclusive)
		return randomBet;
	}
}
