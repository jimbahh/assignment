package diceGame;

//subclass of Player
public class PlayerOne extends Player {
	private static PlayerOne playerOne = new PlayerOne();

	  //use PlayerOne.getInstance() to ensure that all references to a "PlayerOne" are to the same instance
	  // e.g	static PlayerOne playerOne = PlayerOne.getInstance();
	
	public static PlayerOne getInstance() {
	        return playerOne;
	}
}
