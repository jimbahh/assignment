package diceGame;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	 //testing 
	//use the following two lines in each class to ensure that each reference is to the same instance
	static PlayerOne playerOne = PlayerOne.getInstance();
	static PlayerTwo playerTwo = PlayerTwo.getInstance();
	public static void main(String[] args){
		
		playerOne.name = "PlayerOneTest";
		playerOne.money = 300;
		playerTwo.name = "PlayerTwoTest";
		playerTwo.money = 300;
		
		Game game = new Game(5, 2, playerOne, playerTwo);
		
					
		while(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds() && game.hasRoundsRemaining()) {
			game.newRound();
			System.out.println("Winner is " + game.getGameWinner(100).getName());
			System.out.println("p1 " + playerOne.getMoney());
			System.out.println("p2 " + playerTwo.getMoney());
		}
	}	
}