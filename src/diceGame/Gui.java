package diceGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui {
	
	private static String[] diceNumbers = {"1", "2", "3", "4", "5"};
	private static Integer[] roundNumbers = {1, 3, 5};
	private static Game game = new Game();
	private static Player playerOne = new Player();
	private static Player playerTwo = new Player();
	
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
				playerOne = new Player (txtPlayer1Name.getText(), Integer.parseInt(txtStartingMoney.getText()));
				playerTwo = new Player (txtPlayer2Name.getText(), Integer.parseInt(txtStartingMoney.getText()));
				game = new Game(Integer.parseInt(cBoxRoundNumber.getSelectedItem().toString()), cBoxDiceNumber.getSelectedIndex()+1, playerOne, playerTwo);
				frame.dispose();
				roundWindow();	
			}
		}
		exitButton.addActionListener(new ExitAction());
		startButton.addActionListener(new NewGameAction());
	
		frame.setVisible(true);
	}
	
	private static void roundWindow() {
		JFrame frameGame = new JFrame("Dice Game - GAME ON!");
		frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGame.setLocationRelativeTo(null);
		frameGame.setSize(350, 400);
		
		JPanel playerOnePanel = new JPanel();
		JPanel playerTwoPanel = new JPanel();
		JPanel btnPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		
		JLabel lblPlayer1 = new JLabel(playerOne.getName());
		JLabel lblPlayer2 = new JLabel(playerTwo.getName());
		
		JLabel lblPlayer1Money = new JLabel("$"+playerOne.getMoney());
		JLabel lblPlayer2Money = new JLabel("$"+playerTwo.getMoney());
		
		JLabel lblPlayer1Score = new JLabel("Score: "+playerOne.getScore());
		JLabel lblPlayer2Score = new JLabel("Score: "+playerTwo.getScore());
		
		JLabel lblBetAmount = new JLabel("Round Bet: ");
		JTextField txtBetAmount = new JTextField("0");
		
		JLabel lblRound = new JLabel("Round Start", SwingConstants.CENTER);
		lblRound.setFont(new Font("", Font.BOLD, 20));
		
		JTextArea mainText = new JTextArea(5,10);
		
		JButton btnRoll = new JButton("Roll");
		JButton btnQuit = new JButton("Quit");
		
		class QuitAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				frameGame.dispose();
				initNewGame();
			}		
		}
		
		btnQuit.addActionListener(new QuitAction());
		
		class RollAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				btnRoll.setText("Roll");
				if(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds() && game.hasRoundsRemaining()) {
					game.newRound();
					mainText.setText("");
				}
				else {
					btnRoll.setText("Next Game");
					mainText.setText("Game Winner is" + game.getGameWinner(Integer.parseInt(txtBetAmount.getText())).getName());
					game = new Game(game.getRounds(), game.getDice()+1, playerOne, playerTwo);
					playerOne.resetScore();
					playerTwo.resetScore();
				}
				
				lblRound.setText("Round " + (game.getRound()-1));
				
				lblPlayer1Money.setText("$" + playerOne.getMoney());
				lblPlayer2Money.setText("$" + playerTwo.getMoney());
				
				lblPlayer1Score.setText("Score: " + playerOne.getScore());
				lblPlayer2Score.setText("Score: " + playerTwo.getScore());
				
				//console debug
				//System.out.println("Round Winner is " + game.getWinner().getName());
				System.out.println("p1 " + playerOne.getMoney());
				System.out.println("p2 " + playerTwo.getMoney());
			}
		}
		
		btnRoll.addActionListener(new RollAction());
		
		playerOnePanel.add(lblPlayer1);
		playerOnePanel.add(lblPlayer1Money);
		playerOnePanel.add(lblPlayer1Score);
		
		playerTwoPanel.add(lblPlayer2);
		playerTwoPanel.add(lblPlayer2Money);
		playerTwoPanel.add(lblPlayer2Score);
		
		centerPanel.add(mainText);
		centerPanel.add(lblBetAmount);
		centerPanel.add(txtBetAmount);
		
		btnPanel.add(btnRoll);
		btnPanel.add(btnQuit);
		
		frameGame.getContentPane().add(BorderLayout.NORTH, lblRound);
		frameGame.getContentPane().add(BorderLayout.WEST, playerOnePanel);
		frameGame.getContentPane().add(BorderLayout.EAST, playerTwoPanel);
		frameGame.getContentPane().add(BorderLayout.SOUTH, btnPanel);
		frameGame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		frameGame.setVisible(true);
	}
	
	public static void main(String args[]) {
		initNewGame();
	}
}