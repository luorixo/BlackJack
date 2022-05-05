package nz.ac.auckland.se281.a3.bot;

public class BotFactory {
	public static Bot createBot(String name, String type) {
		switch (type) {
		case "R":
			return new Bot(name, new RandomStrategy());
		
		case "LR":
			return new Bot(name, new LowRiskStrategy());
			
		case "HR":
			return new Bot(name, new HighRiskStrategy());
		
		default:
			System.err.println("Wrong Bot Strategy Type!");
			System.exit(0);
		}
		return null;
	}
}
