package diceGame;

import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class Frame {
	static JFrame frame = new JFrame();
	static Game game = new Game();
	static PlayerOne playerOne = PlayerOne.getInstance();
	static PlayerTwo playerTwo = PlayerTwo.getInstance();
	JLabel lblNamePlayerOne;
	JLabel lblNamePlayerTwo;
	JLabel lblFundsPlayerOne;
	JLabel lblFundsPlayerTwo;
	JLabel lblScorePlayerOne;
	JLabel lblScorePlayerTwo;
	static JLabel lblDiceGame = new JLabel("New Game");		


	//Initialize the contents of the frame
	void initializeFrame() {
		frame.setTitle("I Can't Wait To Dice!");
		frame.setBounds(100, 100, 450, 310);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}

	static void setVisible() {
		frame.setVisible(true);
	}
	static void setInvisible() {
		frame.setVisible(true);
	}

	static void setLocationRelativeTo() {
		frame.setLocationRelativeTo(null);
		
	}
	
}
