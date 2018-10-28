package diceGame;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	//testing 
	public static void main(String[] args){
		
		Player playerOne = new Player("Player 1 Test");
		Player playerTwo = new Player("Player 2 Test");
		
		Game game = new Game(3, 2, "Player 1 Test", "Player 2 Test", 300, 100);
		game.newGame();
		System.out.println("Winner is " + game.getWinner().getName());
		System.out.println("p1 " + playerOne.getMoney());
		System.out.println("p2 " + playerTwo.getMoney());
		
		
		while(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds()) {
			System.out.println("\ngame 2\n");
			Game game1 = new Game(3, 2, playerOne, playerTwo, 100);
			game1.newGame();
			System.out.println("Winner is " + game.getWinner().getName());
			System.out.println("p1 " + playerOne.getMoney());
			System.out.println("p2 " + playerTwo.getMoney());
		}
	}	
}