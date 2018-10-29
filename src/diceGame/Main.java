package diceGame;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	//testing 
	public static void main(String[] args){
		
		Player playerOne = new Player("Player 1 Test", 300);
		Player playerTwo = new Player("Player 2 Test", 300);
		
		Game game = new Game(5, 2, playerOne, playerTwo);
		
					
		while(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds() && game.hasRoundsRemaining()) {
			game.newRound();
			System.out.println("Winner is " + game.getGameWinner(100).getName());
			System.out.println("p1 " + playerOne.getMoney());
			System.out.println("p2 " + playerTwo.getMoney());
		}
	}	
}