package diceGame;

import java.util.Random;

public class Game {
	private int currentRound = 1;
	private int numberOfRounds = 3;
	private int numberOfDice = 2;
	PlayerOne playerOne = PlayerOne.getInstance();
	PlayerTwo playerTwo = PlayerTwo.getInstance();
	
	public Game() {
		
	}
	
	public Game(int numberOfRounds, int numberOfDice, PlayerOne playerOne, PlayerTwo playerTwo) {
		this.numberOfRounds = numberOfRounds;
		this.numberOfDice = numberOfDice;
		
	}
	
	public int getRounds() {
		return numberOfRounds;
	}
	
	public int getDice() {
		return numberOfDice;
	}
	
	public int getRound() {
		return currentRound;
	}
		
	public boolean hasRoundsRemaining() {
		if (currentRound > numberOfRounds)
		{
			return false;
		}
		return true;
	}
		
	public boolean coinFlip() {
		Random flip = new Random();
		if (flip.nextInt(2) == 1) {
			return true;
		}
		return false;
	}
	
	public Player getWinner() {
			if (playerOne.getScore() == playerTwo.getScore() && playerOne.getScore() > 0) {
			WindowGUI.gameMenu.coinImage();
			
			if (coinFlip()) {
				return playerOne;
			}
			else {
				return playerTwo;
			}
		}
		else if (playerOne.getScore() > playerTwo.getScore()) {
			return playerOne;
		}
		else {
			return playerTwo;
		}
	}
	
	public boolean newRound() {
		//if(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds()) {
			if(hasRoundsRemaining()) {
				System.out.println("Round "+currentRound + " of " + (numberOfRounds));
				playerOne.roll(numberOfDice);
				playerTwo.roll(numberOfDice);
				System.out.println("Player 1 dice: " + playerOne.thisRoundRolls);
				System.out.println("Player 2 dice: " + playerTwo.thisRoundRolls);
				currentRound ++;
				return true;
			}
			else {
				return false;
			}
		//}
	}
	
	public void setCurrentRound(int round) {
		this.currentRound = round;
	}
	
	public Player getBetWinner(int bet) {
		if (getWinner()==playerOne) {
			playerOne.setMoney(bet);
			playerTwo.setMoney(bet*-1);
			System.out.println("Win "+playerOne.getName());
			System.out.println("P1: "+playerOne.getMoney());
			System.out.println("P2: "+playerTwo.getMoney());
			return playerOne;
		}
		else {
			playerOne.setMoney(bet*-1);
			playerTwo.setMoney(bet);
			System.out.println("Win "+playerTwo.getName());
			System.out.println("P1: "+playerOne.getMoney());
			System.out.println("P2: "+playerTwo.getMoney());
			return playerTwo;
		}
	}
}