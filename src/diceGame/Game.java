package diceGame;

import java.util.Random;

public class Game {
	private int bet =0;
	private int rounds = 3;
	private int diceNumber = 2;
	Player playerOne = new Player("Player 1");
	Player playerTwo = new Player("Player 2");
	
	public Game() {
	}
	
	public Game(int rounds, int diceNumber, Player playerOne, Player playerTwo, int bet) {
		this.rounds = rounds;
		this.diceNumber = diceNumber;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.bet = bet;
	}
	
	public Game(int rounds, int diceNumber, String playerOne, String playerTwo, int money, int bet) {
		this.rounds = rounds;
		this.diceNumber = diceNumber;
		this.playerOne.setName(playerOne);
		this.playerTwo.setName(playerTwo);
		this.playerOne.setMoney(money);
		this.playerTwo.setMoney(money);
		this.bet = bet;
	}
	
	
	public void setBet(Player winner, Player loser) {
		winner.setMoney(bet);
		loser.setMoney(bet*-1);
	}

		
	public boolean coinFlip() {
		Random flip = new Random();
		if (flip.nextInt(2) == 1) {
			return true;
		}
		return false;
	}
	
	public Player getWinner() {
		if (playerOne.getScore() == playerTwo.getScore()) {
			System.out.println("Round Draw Flipping Coin...");
			if (coinFlip()) {
				setBet(playerOne, playerTwo);
				return playerOne;
			}
			else {
				setBet(playerTwo, playerOne);
				return playerTwo;
			}
		}
		else if (playerOne.getScore() > playerTwo.getScore()) {
			setBet(playerOne, playerTwo);
			return playerOne;
		}
		else {
			setBet(playerTwo, playerOne);
			return playerTwo;
		}
	}
	
	public void newGame() {
		for (int i = 0; i < rounds; i++) {
			int round = i+1;
			System.out.println("Round "+round);
			playerOne.roll(diceNumber);
			playerTwo.roll(diceNumber);
		}
	}
	
}
