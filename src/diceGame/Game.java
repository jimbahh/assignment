package diceGame;

import java.util.Random;

public class Game {
	private int currentRound = 1;
	private int numberOfRounds = 3;
	private int numberOfDice = 2;
	Player playerOne = new Player();
	Player playerTwo = new Player();
	
	public Game() {
	}
	
	public Game(int numberOfRounds, int numberOfDice, Player playerOne, Player playerTwo) {
		this.numberOfRounds = numberOfRounds;
		this.numberOfDice = numberOfDice;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
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
		if (currentRound > numberOfRounds) {
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
	
	public Player getRoundWinner() {
		if (playerOne.getScore() == playerTwo.getScore()) {
			System.out.println("Round Draw Flipping Coin...");
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
	
	public void newRound(int bet) {
		if(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds()) {
			if(currentRound <= numberOfRounds) {
				System.out.println("Round "+currentRound + " of " + (numberOfRounds));
				playerOne.roll(numberOfDice);
				playerTwo.roll(numberOfDice);
				currentRound ++;
			}
			else {
				this.getGameWinner(bet);
			}
		}
	}
	
	public void setCurrentRound(int round) {
		this.currentRound = round;
	}
	
	public Player getGameWinner(int bet) {
		if (getRoundWinner()==playerOne) {
			playerOne.setMoney(bet);
			playerTwo.setMoney(bet*-1);
			return playerOne;
		}
		else {
			playerOne.setMoney(bet*-1);
			playerTwo.setMoney(bet);
			return playerTwo;
		}
	}
}