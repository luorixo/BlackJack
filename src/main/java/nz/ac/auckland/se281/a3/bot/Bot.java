package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	// initializing botStrategy variable
	private final BotStrategy botStrategy;

	/**
	 * Bot constructor. Takes in the bot name and the strategy for the bot to
	 * follow, and stores the strategy in the botStrategy variable.
	 * 
	 * @param name        the name of the bot
	 * @param botStrategy the strategy for the bot to follow
	 */
	public Bot(String name, BotStrategy botStrategy) {
		super(name);
		this.botStrategy = botStrategy;
	}

	@Override
	public Action decideAction(Hand hand) {
		return botStrategy.decideAction(hand); // decides action based on bot strategy
	}

	@Override
	public int makeABet() {
		return botStrategy.makeABet(); // makes bet based on bot strategy
	}
}