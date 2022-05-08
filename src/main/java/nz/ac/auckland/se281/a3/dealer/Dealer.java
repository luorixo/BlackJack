package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

/**
 * Class representing dealer object in the Blackjack game. Has a name and
 * corresponding strategy.
 * 
 */
public class Dealer extends Participant {

	private DealerStrategy strategy; // to store strategy

	public Dealer(String name, DealerStrategy strategy) {
		super(name);
		this.strategy = strategy;
	}

	public void setStrategy(DealerStrategy strategyToSet) {
		this.strategy = strategyToSet; // sets strategy based on input
	}

	@Override
	public Action decideAction(Hand hand) {
		return strategy.decideAction(hand); // decides on an action (hold or hit), based on strategy
	}

}
