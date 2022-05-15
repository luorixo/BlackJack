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

	public void incrementWins() {
		this.wins++;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses(int round) {
		return (round - wins);
	}

	public int getNetWins(int round) {
		return (getWins() - getLosses(round));
	}
}
