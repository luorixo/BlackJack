package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

/**
 * This class is an implementation of a dealer strategy for
 * targeting the highest bidder in the game
 * 
 * @author Eugene Chua
 */
public class HighestBidderStrategy implements DealerStrategy{
	
	BlackJack currentGame; // to store current game instance
	public HighestBidderStrategy(BlackJack currentGame) {
		this.currentGame = currentGame;
	}
	
	/**
	 * 
	 * @return the highest bidder (player who has bet the most chips)
	 */
	private Player getHighestBidder() {
		List<Player> playerList = currentGame.getPlayers(); // get list of players
		
		Player highestBidder = playerList.get(0);
		
		// foreach code modified from: https://stackoverflow.com/questions/5710059/java-foreach-skip-first-iteration
		for (Player player : playerList.subList(1, playerList.size())) { // iterates through playerList (skips first iteration)
			
			// checks if current player has a bet higher than current highestBidder, if so changes highestBidder
			if(player.getHand().getBet() > highestBidder.getHand().getBet()) {
				highestBidder = player;
			}
		}
		return highestBidder;
	}

	@Override
	public Action decideAction(Hand hand) {
		Player highestBidder = getHighestBidder();
		int highestBidderScore = highestBidder.getHand().getScore();
		int dealerScore = hand.getScore();
		
		// checks if bidder has blackjack and dealer does not (edge case)
		if(highestBidder.getHand().isBlackJack() && !hand.isBlackJack()) {
			if(dealerScore >= 17) { // checks if current score is at least 17, if so holds, otherwise hits
				return Action.HOLD;
			}else {
				return Action.HIT;
			}
		}else { // if dealer has already beaten targeted player, holds, otherwise hits
			if((dealerScore >= highestBidderScore) || (highestBidder.getHand().isBust())) {
				return Action.HOLD;
			}else {
				return Action.HIT;
			}
		}
	}
}