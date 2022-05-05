package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import java.util.Random;

public class RandomStrategy implements BotStrategy {

	@Override
	public Action decideAction(Hand hand) {
		// TODO Auto-generated method stub
		Random randomBool = new Random();
		
		boolean toHit = randomBool.nextBoolean();
		
		if(toHit) {
			return Action.HIT;
		}else {
			return Action.HOLD;
		}
	}

	@Override
	public int makeABet() {
		// TODO Auto-generated method stub
		Random randomInt = new Random();
		
		int randomBet = (randomInt.nextInt(100)) + 1; // random no. from 1-100 (inclusive)
		return randomBet;
	}
	
}