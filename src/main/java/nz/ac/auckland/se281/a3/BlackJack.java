package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.bot.BotFactory;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.HighestBidderStrategy;
import nz.ac.auckland.se281.a3.dealer.TopWinnerStrategy;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {
	
	private int totalRounds; // to store the final round no.
	private List<Player> players;
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * This constructor is for testing purposes only.
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		totalRounds = round;
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * Initializes bots and adds them to the players list (strategy depends on user input).
	 */
	protected void initBots() {
		String botStrategyString = getBotStrategy(); // gets bot strategy user input as string
		
		// bot creation factory creates bots (with appropriate strategies) based on the string
		Bot bot1 = BotFactory.createBot("Bot1", botStrategyString);
		Bot bot2 = BotFactory.createBot("Bot2", botStrategyString);
		
		// adds bots to players list
		players.add(bot1);
		players.add(bot2);
	}

	/**
	 * Initializes a new dealer instance with a 'target highest bidder' strategy.
	 */
	protected void initDealer() {
		// initial dealer strategy: Target Highest Bidder
		dealer = new Dealer("Dealer", new HighestBidderStrategy(this));
	}

	/**
	 * Prints statistics for current round (which player(s) won and what they bet), and determines
	 * if there should be a change in the dealer strategy (checks if any player has net wins greater
	 * than 2).
	 * 
	 * @param round the current round number
	 */
	protected void printAndUpdateResults(int round) {
		List<Player> twoNetWinsList = new ArrayList<>();
		
		for (Player player : players) {
			String lostOrWon = "lost";
			if(!player.getHand().isBust()) {
				if((player.getHand().getScore() > dealer.getHand().getScore()) || (player.getHand().isBlackJack() && !dealer.getHand().isBlackJack()) || dealer.getHand().isBust()) {
					player.incrementWins();
					lostOrWon = "won";
				}
			}
			if((round >= 2) && (player.getNetWins(round) >= 2)) {
				twoNetWinsList.add(player);
			}
			
			System.out.println("Round "+round+": "+player.getName()+" "+lostOrWon+" "+player.getHand().getBet()+" chips");
		}
		
		if(twoNetWinsList.isEmpty()) {
			dealer.setStrategy(new HighestBidderStrategy(this));
		}else {
			Player topWinner = twoNetWinsList.get(0);
			// foreach code modified from: https://stackoverflow.com/questions/5710059/java-foreach-skip-first-iteration
			for (Player twoNetWinsPlayer : twoNetWinsList.subList(1, twoNetWinsList.size())) {
				if(twoNetWinsPlayer.getNetWins(round) > topWinner.getNetWins(round)) {
					topWinner = twoNetWinsPlayer;
				}
			}
			dealer.setStrategy(new TopWinnerStrategy(this, topWinner));
		}	
	}

	/**
     * Prints end of game statistics. (player name, no. of wins, and no. of losses).
	 */
	protected void printGameStatistics() {
		for(Player player : players) {
			System.out.println(player.getName()+" won "+player.getWins()+" times and lost "+player.getLosses(totalRounds)+" times");
		}
	}
}
