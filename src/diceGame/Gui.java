package diceGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Gui {
	
	private static String[] diceNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private static Integer[] roundNumbers = {1, 3, 5, 7, 9};
	
	private static void initNewGame() {
		
		JFrame frame = new JFrame("Dice Game - New Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(350, 400);
	
		JPanel panel = new JPanel(); 
		JPanel panelButton = new JPanel(); 
	
		JLabel lblMain = new JLabel("New Game", SwingConstants.CENTER);
		lblMain.setFont(new Font("", Font.BOLD, 20));
	
		JLabel lblPlayer1 = new JLabel("Player 1:");
		JLabel lblPlayer2 = new JLabel("Player 2:");
		JLabel lblNumberOfDice = new JLabel("Number of Dice:");
		JLabel lblNumberOfRounds = new JLabel("Number of Rounds:");
		JLabel lblStartingMoney = new JLabel("Starting Money:");
	
		JTextField txtPlayer1Name = new JTextField("Player 1", 20);
		JTextField txtPlayer2Name = new JTextField("Player 2", 20);
		JTextField txtStartingMoney = new JTextField("300", 20);
	
		JComboBox<String> cBoxDiceNumber = new JComboBox<>(diceNumbers);
		cBoxDiceNumber.setSelectedIndex(1);
	
		JComboBox<Integer> cBoxRoundNumber = new JComboBox<>(roundNumbers);
		cBoxRoundNumber.setSelectedIndex(1);
	
		JButton startButton = new JButton("Start");
		JButton exitButton = new JButton("Exit");
	
		panel.add(lblPlayer1);
		panel.add(txtPlayer1Name);
		panel.add(lblPlayer2);
		panel.add(txtPlayer2Name);
		panel.add(lblNumberOfDice);
		panel.add(cBoxDiceNumber);
		panel.add(lblNumberOfRounds);
		panel.add(cBoxRoundNumber);
		panel.add(lblStartingMoney);
		panel.add(txtStartingMoney);
	
		panelButton.add(startButton);
		panelButton.add(exitButton);
	
		frame.getContentPane().add(BorderLayout.NORTH, lblMain);
		frame.getContentPane().add(BorderLayout.CENTER, panel);
		frame.getContentPane().add(BorderLayout.SOUTH, panelButton);
		
		class ExitAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
		}
	
		class NewGameAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Player playerOne = new Player (txtPlayer1Name.getText(), Integer.parseInt(txtStartingMoney.getText()));
				Player playerTwo = new Player (txtPlayer2Name.getText(), Integer.parseInt(txtStartingMoney.getText()));
				Game game = new Game(Integer.parseInt(cBoxRoundNumber.getSelectedItem().toString()), cBoxDiceNumber.getSelectedIndex()+1, playerOne, playerTwo, 100);
				game.newRound();
				frame.dispose();
				roundWindow(game);
				
			}
		}

		exitButton.addActionListener(new ExitAction());
		startButton.addActionListener(new NewGameAction());
	
		frame.setVisible(true);
		
	}
	
	private static void roundWindow(Game game) {
		JFrame frameGame = new JFrame("Dice Game - GAME ON!");
		frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGame.setLocationRelativeTo(null);
		frameGame.setSize(350, 400);
		
		//JLabel lblRound = new JLabel();
		
		
		frameGame.setVisible(true);
	}
	
	public static void main(String args[]) {
		initNewGame();
	}
}

