package nz.ac.auckland.se281.a3.bot;

/**
 * This factory class takes name and strategy types and creates bots accordingly
 * 
 * @author Eugene Chua (UPI: echu192)
 */
public class BotFactory {

	/**
	 * Creates and returns a Bot instance dependent on the strategy type input.
	 * 
	 * @param name the name of the bot
	 * @param type the strategy type of the bot
	 * @return new bot instance of appropriate name/strategy
	 */
	public static Bot createBot(String name, String type) {
		switch (type) {
		case "R": // random strategy bot
			return new Bot(name, new RandomStrategy());

		case "LR": // low risk strategy bot
			return new Bot(name, new LowRiskStrategy());

		case "HR": // high risk strategy bot
			return new Bot(name, new HighRiskStrategy());

		default:
			System.err.println("Wrong Bot Strategy Type!"); // print error message
			System.exit(0);
		}
		return null;
	}
}
