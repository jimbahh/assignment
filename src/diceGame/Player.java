package diceGame;

import java.util.ArrayList;
import java.util.Random;

public abstract class Player {
	protected String name ="";
	private int score = 0;
	int money = 0;
	int roundScore = 0;
	//the ArrayList for ALL dice rolls, probably best to be deleted at some stage lol
	//ArrayList<Integer> totalNumberList = new ArrayList<Integer>();
	
	//the ArrayList for THIS ROUND'S dice rolls, cleared after each round
	ArrayList<Integer> thisRoundRolls = new ArrayList<Integer>();

	int randomNumbers;
	
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
		//making the roll an int makes it possible to add the same Random value to an ArrayList
		int randomNumbers = roll.nextInt(6)+1;
		
		//adds each value of each dice for each player to an arrayList, then prints to console	//totalNumberList.add(randomNumbers);
		thisRoundRolls.add(randomNumbers);
		System.out.println(name + " rolled " + randomNumbers);
		return randomNumbers;
		
		
	}
	
	//adds the values in the array together to get the score for the round
	//initializing the int to 0 made the scores always empty hahahahahaha.
	public int getRoundScore() {		
		for(Integer x : thisRoundRolls)
		    roundScore += x;
	//System.out.println(name +" Round Score: " + this.roundScore);
		return roundScore;
	}
	
	//use this to empty thisRoundRolls AND roundscore after each round
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
} 
