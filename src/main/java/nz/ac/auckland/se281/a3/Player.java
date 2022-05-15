package nz.ac.auckland.se281.a3;

/**
 * Class representing a player object (human player of bot player) Has
 * getters/setters for no. of wins/losses
 *
 */
public abstract class Player extends Participant {

	private int wins; // stores no. of wins

	public Player(String name) {
		super(name);
		this.wins = 0;
	}

	public abstract int makeABet();

	/**
	 * Player method to increment the number of wins by one win when called.
	 */
	public void incrementWins() {
		this.wins++;
	}

	public int getWins() {
		return wins;
	}

	/**
	 * Computes and returns the total number of losses. Calculates this by doing
	 * (current round - wins).
	 * 
	 * @param round the current round
	 * @return the number of losses (round - wins)
	 */
	public int getLosses(int round) {
		return (round - wins);
	}

	/**
	 * Computes and returns the total net wins of the player. Calculates this by
	 * doing wins - losses.
	 * 
	 * @param round the current round
	 * @return the player's net wins
	 */
	public int getNetWins(int round) {
		return (getWins() - getLosses(round));
	}
}
