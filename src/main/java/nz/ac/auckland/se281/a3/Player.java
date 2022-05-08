package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {
	
	private int wins;
	
	public Player(String name) {
		super(name);
		this.wins = 0;
	}

	public abstract int makeABet();
	
	/**
	 * 
	 */
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
