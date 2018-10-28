package diceGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Gui {
public static void main(String args[]) {

//Creating the Frame
	JFrame frame = new JFrame("Dice Game - New Game");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(350, 400);

	JPanel panel = new JPanel(); 
	JPanel buttonPanel = new JPanel(); 
	
	JLabel mainLabel = new JLabel("New Game", SwingConstants.CENTER);
	mainLabel.setFont(new Font("", Font.BOLD, 20));
	JLabel p1Label = new JLabel("Player 1:");
	JLabel p2Label = new JLabel("Player 2:");
	JLabel diceLabel = new JLabel("Number of Dice:");
	JLabel roundLabel = new JLabel("Number of Rounds:");
	JLabel moneyLabel = new JLabel("Starting Money:");
	
	JTextField p1Name = new JTextField("Player 1", 20);
	JTextField p2Name = new JTextField("Player 2", 20);
	JTextField moneyValue = new JTextField("300", 20);
	
	String[] diceNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	JComboBox<String> diceNumber = new JComboBox<>(diceNumbers);
	diceNumber.setSelectedItem(2);
	
	Integer[] roundNumbers = {1, 3, 5, 7, 9};
	JComboBox<Integer> roundNumber = new JComboBox<>(roundNumbers);
	
	roundNumber.setSelectedIndex(1);
	diceNumber.setSelectedIndex(1);
	
	
	JButton startButton = new JButton("Start");
	JButton exitButton = new JButton("Exit");
	panel.add(p1Label);
	panel.add(p1Name);
	panel.add(p2Label);
	panel.add(p2Name);
	panel.add(diceLabel);
	panel.add(diceNumber);
	panel.add(roundLabel);
	panel.add(roundNumber);
	panel.add(moneyLabel);
	panel.add(moneyValue);
	
	buttonPanel.add(startButton);
	buttonPanel.add(exitButton);
	
	
	
	//Adding Components to the frame.

	frame.getContentPane().add(BorderLayout.NORTH, mainLabel);
	frame.getContentPane().add(BorderLayout.CENTER, panel);
	frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
	
	class ExitAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			System.exit(0);		
		}
	}
	
	class NewGameAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Game game = new Game(Integer.parseInt(roundNumber.getSelectedItem().toString()), diceNumber.getSelectedIndex()+1, p1Name.getText(), p2Name.getText(), Integer.parseInt(moneyValue.getText()), 100);
			game.newGame();
		}
	}

	exitButton.addActionListener(new ExitAction());
	startButton.addActionListener(new NewGameAction());
	
	frame.setVisible(true);
	}
}

