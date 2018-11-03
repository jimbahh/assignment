package diceGame;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.Assert.*;

//import org.junit.jupiter.api.RepeatedTest;

public class Test {
	PlayerOne playerOne = PlayerOne.getInstance();
	PlayerTwo playerTwo = PlayerTwo.getInstance();
	
	Game testGame = new Game();
	
	//tests that each dice gives a value of 1-6, does so 10 times
	@org.junit.Test
	@RepeatedTest(1)
	public void sixSidedDiceTest() {
			int diceroll1 = playerOne.diceRoll();
			int diceroll2 = playerTwo.diceRoll();
			assertTrue(1 <= diceroll1 && diceroll1 <= 6);
			assertTrue(1 <= diceroll2 && diceroll2 <= 6);			
	}
	
	
	//tests thisRoundRolls are clearing and filling as intended, repeated 10 times
	@org.junit.Test
	@RepeatedTest(10)
	public void listTest() {
		testGame.newRound();
		assertFalse(playerOne.thisRoundRolls.isEmpty());
		assertFalse(playerTwo.thisRoundRolls.isEmpty());
		playerOne.clearRoundScore();
		playerTwo.clearRoundScore();
		assertTrue(playerOne.thisRoundRolls.isEmpty());
		assertTrue(playerTwo.thisRoundRolls.isEmpty());
	}
	
	@org.junit.Test
	@RepeatedTest(5)
	public void roundScoreTest() {
	playerOne.diceRoll();
	playerTwo.diceRoll();
	System.out.println("P1: " + playerOne.thisRoundRolls);
	System.out.println("P2: " +playerTwo.thisRoundRolls);
	playerOne.getRoundScore();
	playerTwo.getRoundScore();
		System.out.println("Clearing round scores....");
	playerOne.clearRoundScore();
	playerTwo.clearRoundScore();
	assertEquals(0, playerOne.getRandomNumbers());
	assertEquals(0, playerTwo.getRandomNumbers());
	}
}

