package diceGame;

import java.awt.*;
import javax.swing.*;


public class Gui {
public static void main(String args[]) {

//Creating the Frame
	JFrame frame = new JFrame("Dice Game - New Game");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(400, 400);

	JPanel panel = new JPanel(); 
	JPanel panel1 = new JPanel(); 
	JLabel mainLabel = new JLabel("NEW GAME");
	JLabel p1Label = new JLabel("Player 1:");
	JLabel p2Label = new JLabel("Player 2:");
	JTextField p1Name = new JTextField(12);
	JTextField p2Name = new JTextField(12);
	JButton startButton = new JButton("Start");
	JButton exitButton = new JButton("Exit");
	panel.add(p1Label);
	panel.add(p1Name);
	panel.add(p2Label);
	panel.add(p2Name);
	panel1.add(startButton);
	panel1.add(exitButton);

	
	//Adding Components to the frame.

	frame.getContentPane().add(BorderLayout.NORTH, mainLabel);
	frame.getContentPane().add(BorderLayout.CENTER, panel);
	frame.getContentPane().add(BorderLayout.SOUTH, mainLabel);

	
	frame.setVisible(true);
	}
}

