package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LowRiskStrategy implements BotStrategy {
	@Override
	public Action decideAction(Hand hand) {
		// TODO Auto-generated method stub
		int currentScore = hand.getScore();
		
		if(currentScore >= 17) {
			return Action.HOLD;
		}else {
			return Action.HIT;
		}
	}

	@Override
	public int makeABet() {
		// TODO Auto-generated method stub
		Random randomInt = new Random();
		
		int randomBet = (randomInt.nextInt(41)) + 10; // random no. from 10-50 (inclusive)
		return randomBet;
	}
}
