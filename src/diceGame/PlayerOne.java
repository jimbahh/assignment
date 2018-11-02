package diceGame;

public class PlayerOne extends Player {
	private static PlayerOne playerOne = new PlayerOne();
	
	public static PlayerOne getInstance() {
	        return playerOne;
	}
}
