package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;
import nz.ac.auckland.se281.a3.Participant.Action;

public class TopWinnerStrategy implements DealerStrategy{
	
	BlackJack currentGame;
	public TopWinnerStrategy(BlackJack currentGame, Player topWinner) {
		this.currentGame = currentGame;
	}
	
	private Player getTopWinner() {
		List<Player> playerList = currentGame.getPlayers(); // get list of players
		
		Player topWinner = playerList.get(0);
		
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
		return null;
	}
}