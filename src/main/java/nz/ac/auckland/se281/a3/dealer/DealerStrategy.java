package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface DealerStrategy {
	/**
	 * dealer method to decide action based on the dealer's hand. Action taken
	 * depends on implementation.
	 * 
	 * @param hand the hand of the dealer
	 * @return the action to take, hit or hold
	 */
	Action decideAction(Hand hand);
}
