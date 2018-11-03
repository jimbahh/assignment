package diceGame;

import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class Menu {
	static Game game = new Game();
	static JFrame frame = Frame.getInstance();
	static PlayerOne playerOne = PlayerOne.getInstance();
	static PlayerTwo playerTwo = PlayerTwo.getInstance();
	static JLabel lblNamePlayerOne;
	static JLabel lblNamePlayerTwo;
	static JLabel lblFundsPlayerOne;
	static JLabel lblFundsPlayerTwo;
	static JLabel lblScorePlayerOne;
	static JLabel lblScorePlayerTwo;
	static JLabel lblDiceGame = new JLabel("New Game");		
}