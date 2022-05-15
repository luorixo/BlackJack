package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {
	/**
	 * Bot method that determines which action the bot should make. Either hits, or
	 * holds depending on implementation.
	 * 
	 * @param hand current hand of the bot
	 * @return action to take (hit or hold)
	 */
	Action decideAction(Hand hand); // action (hold or hit) to make

	/**
	 * Bot method that decides on a bet (no. of chips to put). How bets are decided
	 * depend on implementation.
	 * 
	 * @return an integer bet (no. of chips to put)
	 */
	int makeABet(); // how many chips to bet
}