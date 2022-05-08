package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * This class is an implementation of a dealer strategy for targeting the top
 * winner (most net wins) in the game
 * 
 * @author Eugene Chua
 */
public class TopWinnerStrategy implements DealerStrategy {

	Player topWinner; // store top winner target

	BlackJack currentGame;

	public TopWinnerStrategy(BlackJack currentGame, Player topWinner) {
		this.currentGame = currentGame;
		this.topWinner = topWinner;
	}

	/**
	 * Decides action based on the targeted top winner. Will always make move so as
	 * to attempt to beat targeted player
	 * 
	 * @return action to take (hold or hit)
	 */
	@Override
	public Action decideAction(Hand hand) {

		int dealerScore = hand.getScore();

		// checks if bidder has blackjack and dealer does not (edge case)
		if (topWinner.getHand().isBlackJack() && !hand.isBlackJack()) {
			if (dealerScore >= 17) { // checks if current score is at least 17, if so holds, otherwise hits
				return Action.HOLD;
			} else {
				return Action.HIT;
			}
		} else { // if dealer has already beaten targeted player, holds, otherwise hits
			if ((dealerScore >= topWinner.getHand().getScore()) || (topWinner.getHand().isBust())) {
				return Action.HOLD;
			} else {
				return Action.HIT;
			}
		}
	}
}