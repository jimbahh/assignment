package diceGame;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player {
	protected String name ="";
	private int score = 0;
	int money = 0;
	int roundScore = 0;
	ArrayList<Integer> thisRoundRolls = new ArrayList<Integer>();
	private int randomNumbers;
	
	public Player() {
	}
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
	}
		
	public void setMoney(int money) {
		this.money += money;
	}
	
	public void resetScore() {
		this.score = 0;
	}
	
	public void roll(int diceNumber) {
		System.out.println(diceNumber + " dice rolled by " + name + ":");
		for (int i = 0; i < diceNumber; i++) {
			this.score += diceRoll();
		}
	}
		
	int diceRoll() {
		Random roll = new Random();
		int randomNumbers = roll.nextInt(6)+1;
		thisRoundRolls.add(randomNumbers);
		System.out.println(name + " rolled " + randomNumbers);
		return randomNumbers;
	}
	
	public int getRoundScore() {		
		for(Integer x : thisRoundRolls)
		    roundScore += x;
		return roundScore;
	}
	
	public void clearRoundScore () {
		thisRoundRolls.clear();
		roundScore = 0;
	}
	

	public int getScore() {
		return this.score;
	}
		
	public String getName() {
		return this.name;
	}
	
	public int getMoney() {
		return this.money;
	}
	  
	public boolean checkPlayerFunds() {
		if (this.getMoney() <= 0) {
			return false;
		}
		return true;
	}
	
	public int getRandomNumbers() {
		return randomNumbers;
	}
} 
