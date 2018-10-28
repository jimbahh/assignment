package diceGame;

import java.util.Random;

public class Player {
	private String name ="";
	private int score = 0;
	private int money = 0;
	
	public Player(String name) {
		this.name = name;
		this.money = 0;
	}
	
	
	public Player(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMoney(int money) {
		this.money += money;
	}
	
	public void roll(int diceNumber) {
		for (int i = diceNumber; i>0; i--) {
			this.score += diceRoll();
		}
		System.out.println(this.name + " " + this.getScore());
	}
		
	private int diceRoll() {
		Random roll = new Random();
		return roll.nextInt(6)+1;
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
		if (this.getMoney() > 0) {
			return true;
		}
		return false;
	}
} 
