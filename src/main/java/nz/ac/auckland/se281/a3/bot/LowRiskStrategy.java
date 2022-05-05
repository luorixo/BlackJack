package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LowRiskStrategy implements BotStrategy {
	@Override
	public Action decideAction(Hand hand) {
		int currentScore = hand.getScore(); // gets current score
		
		// if score is 17 or greater holds, otherwise hits
		if(currentScore >= 17) {
			return Action.HOLD;
		}else {
			return Action.HIT;
		}
	}

	@Override
	public int makeABet() {
		Random randomInt = new Random();
		
		int randomBet = (randomInt.nextInt(41)) + 10; // generates random no. (bet) from 10-50 (inclusive)
		return randomBet;
	}
}
