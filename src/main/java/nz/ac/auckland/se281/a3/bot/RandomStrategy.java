package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import java.util.Random;

public class RandomStrategy implements BotStrategy {

	/**
	 * Decides on action based on the bot's current score. Decides action randomly
	 * (50% chance to hold/hit)
	 * 
	 * @return the action to take (HOLD or HIT)
	 */
	@Override
	public Action decideAction(Hand hand) {
		Random randomBool = new Random();

		boolean toHit = randomBool.nextBoolean(); // generates random boolean

		if (toHit) { // 50/50 chance to hit or hold
			return Action.HIT;
		} else {
			return Action.HOLD;
		}
	}

	/**
	 * Makes random bet from 1 to 100 (inclusive) Made by pseudo-random no.
	 * generation
	 * 
	 * @return the random bet
	 */
	@Override
	public int makeABet() {
		Random randomInt = new Random();

		int randomBet = (randomInt.nextInt(100)) + 1; // generates random no. (bet) from 1-100 (inclusive)
		return randomBet;
	}

}