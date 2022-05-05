package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HighRiskStrategy implements BotStrategy {
	@Override
	public Action decideAction(Hand hand) {
		// TODO Auto-generated method stub
		int currentScore = hand.getScore();
		
		if(currentScore >= 19) {
			return Action.HOLD;
		}else {
			return Action.HIT;
		}
	}

	@Override
	public int makeABet() {
		// TODO Auto-generated method stub
		Random randomInt = new Random();
		
		int randomBet = (randomInt.nextInt(51)) + 50; // random no. from 50-100 (inclusive)
		return randomBet;
	}
}
