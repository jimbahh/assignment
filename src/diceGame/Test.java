package diceGame;

import static org.junit.Assert.*;

import org.junit.jupiter.api.RepeatedTest;

public class Test {
	PlayerOne playerOne = PlayerOne.getInstance();
	PlayerTwo playerTwo = PlayerTwo.getInstance();
	Game testGame = new Game();
	
	//tests that each dice gives a value of 1-6, does so 10 times
	@org.junit.Test
	@RepeatedTest(10)
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
		playerOne.clearRolls();
		playerTwo.clearRolls();
		assertTrue(playerOne.thisRoundRolls.isEmpty());
		assertTrue(playerTwo.thisRoundRolls.isEmpty());
	}
	
	@org.junit.Test
	public void coinFlipTest() {
		playerOne.roundScore = 0;
		playerTwo.roundScore = 0;
		testGame.getRoundWinner();
	}
}

