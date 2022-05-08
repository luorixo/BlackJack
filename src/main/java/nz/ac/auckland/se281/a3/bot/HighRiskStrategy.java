package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * This class is an implementation of the BotStrategy interface for using a high
 * risk bot strategy
 * 
 * @author Eugene Chua
 */
public class HighRiskStrategy implements BotStrategy {

	/**
	 * Decides on action based on the bot's current score only holds if score is at
	 * least 19
	 * 
	 * @return the action to take (HOLD or HIT)
	 */
	@Override
	public Action decideAction(Hand hand) {
		int currentScore = hand.getScore(); // gets current score

		// if score is 19 or greater holds, otherwise hits
		if (currentScore >= 19) {
			return Action.HOLD;
		} else {
			return Action.HIT;
		}
	}

	/**
	 * Makes random bet from 50 to 100 (inclusive) Made by pseudo-random no.
	 * generation
	 * 
	 * @return the random bet
	 */
	@Override
	public int makeABet() {
		Random randomInt = new Random();

		int randomBet = (randomInt.nextInt(51)) + 50; // generates random no. (bet) from 50-100 (inclusive)
		return randomBet;
	}
}
