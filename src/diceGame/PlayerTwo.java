package diceGame;

public class PlayerTwo extends Player {
	private static PlayerTwo playerTwo = new PlayerTwo();
	
	public static PlayerTwo getInstance() {
	        return playerTwo;
	}
}