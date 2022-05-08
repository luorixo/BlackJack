package nz.ac.auckland.se281.a3;

/**
 * Class representing a player object (human player of bot player)
 * Has getters/setters for no. of wins/losses
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
	 * Adder function to increment wins by 1
	 */
	public void incrementWins() {
		this.wins++;
	}
	
	/**
	 * Getter function to get no. of wins
	 * 
	 * @return no. of current wins
	 */
	public int getWins() {
		return wins;
	}
	
	/**
	 * Getter function to get no. of losses
	 * 
	 * @return no. of current losses
	 */
	public int getLosses(int round) {
		return (round - wins);
	}
	
	/**
	 * Getter function to get the net number of wins (wins - losses)
	 * 
	 * @return no. of net wins
	 */
	public int getNetWins(int round) {
		return (getWins() - getLosses(round));
	}

}
