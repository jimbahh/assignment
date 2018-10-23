package diceGame;

import java.awt.*;
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
	JTextField p1Name = new JTextField("Player 1", 20);
	JTextField p2Name = new JTextField("Player 2", 20);
	JButton startButton = new JButton("Start");
	JButton exitButton = new JButton("Exit");
	panel.add(p1Label);
	panel.add(p1Name);
	panel.add(p2Label);
	panel.add(p2Name);
	buttonPanel.add(startButton);
	buttonPanel.add(exitButton);

	
	//Adding Components to the frame.

	frame.getContentPane().add(BorderLayout.NORTH, mainLabel);
	frame.getContentPane().add(BorderLayout.CENTER, panel);

	frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

	
	frame.setVisible(true);
	}
}

