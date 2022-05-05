package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HighRiskStrategy implements BotStrategy {
	@Override
	public Action decideAction(Hand hand) {
		int currentScore = hand.getScore(); // gets current score
		
		// if score is 19 or greater holds, otherwise hits
		if(currentScore >= 19) {
			return Action.HOLD;
		}else {
			return Action.HIT;
		}
	}

	@Override
	public int makeABet() {
		Random randomInt = new Random();
		
		int randomBet = (randomInt.nextInt(51)) + 50; // generates random no. (bet) from 50-100 (inclusive)
		return randomBet;
	}
}
