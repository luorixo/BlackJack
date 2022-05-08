package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;
import nz.ac.auckland.se281.a3.Participant.Action;

public class TopWinnerStrategy implements DealerStrategy{
	
	Player topWinner;
	
	BlackJack currentGame;
	public TopWinnerStrategy(BlackJack currentGame, Player topWinner) {
		this.currentGame = currentGame;
		this.topWinner = topWinner;
	}
	
	@Override
	public Action decideAction(Hand hand) {
		
		int dealerScore = hand.getScore();
		
		if(topWinner.getHand().isBlackJack() && !hand.isBlackJack()) {
			if(dealerScore >= 17) {
				return Action.HOLD;
			}else {
				return Action.HIT;
			}
		}else {
			if((dealerScore >= topWinner.getHand().getScore()) || (topWinner.getHand().isBust())) {
				return Action.HOLD;
			}else {
				return Action.HIT;
			}
		}
	}
}