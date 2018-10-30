package diceGame;
//subclass of Player
public class PlayerTwo extends Player {
	private static PlayerTwo playerTwo = new PlayerTwo();
	
	 private PlayerTwo() {
		  
	  }
	  //use PlayerTwo.getInstance() to ensure that all references to a "PlayerTwo" are to the same instance
	  // e.g	static PlayerTwo playerTwo = PlayerTwo.getInstance();

    public static PlayerTwo getInstance() {
	        return playerTwo;
	        }
}
