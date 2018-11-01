package diceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class WindowGUI {
	
	//WindowGUI Variables
	private static JFrame frame = new JFrame();
	private static Game game = new Game();
	PlayerOne playerOne = PlayerOne.getInstance();
	PlayerTwo playerTwo = PlayerTwo.getInstance();
	
	//Main Menu Panel Variables
	private JTextField txtPlayerOneName;
	private JTextField txtPlayerTwoName;
	private JTextField txtStartingFunds;
	private final JButton btnStart = new JButton("Start");
	private static String[] diceNumbers = {"1", "2", "3", "4", "5"};
	private static Integer[] roundNumbers = {1, 3, 5};
	private JTextField textRoundBet;
	private JPanel panelMain;
	JComboBox<String> comboBoxDice;
	JComboBox<Integer> comboBoxRounds;
	
	//Game Panel Variables
	JPanel panelGame;
	JLabel lblNamePlayerOne;
	JLabel lblNamePlayerTwo;
	JLabel lblFundsPlayerOne;
	JLabel lblFundsPlayerTwo;
	JLabel lblScorePlayerOne;
	JLabel lblScorePlayerTwo;
	JLabel lblCurrentRound;
	
	//Launches the App
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//WindowGUI.frame.setVisible(true);
					//frame.setLocationRelativeTo(null);
					new WindowGUI();
					WindowGUI.frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the Window
	public WindowGUI() {
		initialize();
	}

	public void initializeMainMenu() {
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 434, 271);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		panelMain.setVisible(true);
		
		JLabel lblDiceGame = new JLabel("New Game", SwingConstants.CENTER);		
		lblDiceGame.setBounds(0, 0, 434, 25);
		lblDiceGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelMain.add(lblDiceGame);
		
		JLabel lblPlayerOneName = new JLabel("Player 1 Name:");
		lblPlayerOneName.setBounds(97, 52, 99, 14);
		panelMain.add(lblPlayerOneName);
		
		JLabel lblPlayerTwoName = new JLabel("Player 2 Name:");
		lblPlayerTwoName.setBounds(97, 77, 109, 14);
		panelMain.add(lblPlayerTwoName);

		JLabel lblNumberOfDice = new JLabel("Number of Dice:");
		lblNumberOfDice.setBounds(97, 121, 123, 14);
		panelMain.add(lblNumberOfDice);
		
		JLabel lblNumberOfRounds = new JLabel("Number of Rounds:");
		lblNumberOfRounds.setBounds(97, 146, 123, 14);
		panelMain.add(lblNumberOfRounds);
		
		JLabel lblPlayerStartingMoney = new JLabel("Player starting Money:");
		lblPlayerStartingMoney.setBounds(97, 185, 155, 14);
		panelMain.add(lblPlayerStartingMoney);
		
		txtPlayerOneName = new JTextField();
		txtPlayerOneName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerOneName.setText("Player 1");
		txtPlayerOneName.setBounds(216, 49, 112, 20);
		panelMain.add(txtPlayerOneName);
		txtPlayerOneName.setColumns(10);
		
		txtPlayerTwoName = new JTextField();
		txtPlayerTwoName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerTwoName.setText("Player 2");
		txtPlayerTwoName.setBounds(216, 74, 112, 20);
		panelMain.add(txtPlayerTwoName);
		txtPlayerTwoName.setColumns(10);
		
		comboBoxDice = new JComboBox<String>(diceNumbers);
		comboBoxDice.setSelectedIndex(1);
		comboBoxDice.setBounds(252, 118, 40, 20);
		panelMain.add(comboBoxDice);
		
		comboBoxRounds = new JComboBox<Integer>(roundNumbers);
		comboBoxRounds.setSelectedIndex(1);
		comboBoxRounds.setBounds(252, 143, 40, 20);
		panelMain.add(comboBoxRounds);
		
		txtStartingFunds = new JTextField();
		txtStartingFunds.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartingFunds.setText("100");
		txtStartingFunds.setBounds(262, 182, 66, 20);
		panelMain.add(txtStartingFunds);
		txtStartingFunds.setColumns(10);
				
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(230, 239, 99, 22);
		panelMain.add(btnExit);
		
	}
	
	public void initializeGameMenu() {
		panelGame = new JPanel();
		panelGame.setBounds(0, 0, 434, 271);
		frame.getContentPane().add(panelGame);
		panelGame.setLayout(null);
		panelGame.setVisible(false);
						
		JLabel lblPlayerOne = new JLabel("Player 1");
		lblPlayerOne.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayerOne.setBounds(21, 11, 46, 14);
		panelGame.add(lblPlayerOne);
		
		lblNamePlayerOne = new JLabel("");
		lblNamePlayerOne.setBounds(21, 28, 46, 14);
		panelGame.add(lblNamePlayerOne);
		
		JLabel lblPlayerTwo = new JLabel("Player 2");
		lblPlayerTwo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayerTwo.setBounds(378, 11, 46, 14);
		panelGame.add(lblPlayerTwo);
		
		lblNamePlayerTwo = new JLabel("");
		lblNamePlayerTwo.setBounds(378, 28, 46, 14);
		panelGame.add(lblNamePlayerTwo);
		
		lblFundsPlayerOne = new JLabel("");
		lblFundsPlayerOne.setBounds(21, 53, 46, 14);
		panelGame.add(lblFundsPlayerOne);
		
		lblFundsPlayerTwo = new JLabel("");
		lblFundsPlayerTwo.setBounds(378, 53, 46, 14);
		panelGame.add(lblFundsPlayerTwo);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(21, 78, 46, 14);
		panelGame.add(lblScore);
		
		lblScorePlayerOne = new JLabel("0");
		lblScorePlayerOne.setBounds(64, 78, 46, 14);
		panelGame.add(lblScorePlayerOne);
		
		JLabel lblScore1 = new JLabel("Score: ");
		lblScore1.setBounds(325, 78, 46, 14);
		panelGame.add(lblScore1);
		
		lblScorePlayerTwo = new JLabel("0");
		lblScorePlayerTwo.setBounds(378, 78, 46, 14);
		panelGame.add(lblScorePlayerTwo);
		
		lblCurrentRound = new JLabel("Round 1");
		lblCurrentRound.setBounds(125, 10, 150, 14);
		panelGame.add(lblCurrentRound);
		
		JLabel lblRoundBet = new JLabel("Round Bet:");
		lblRoundBet.setBounds(150, 212, 70, 14);
		panelGame.add(lblRoundBet);
		
		textRoundBet = new JTextField();
		textRoundBet.setText("10");
		textRoundBet.setBounds(230, 209, 86, 20);
		panelGame.add(textRoundBet);
		textRoundBet.setColumns(10);
		
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGame.setVisible(false);
				panelMain.setVisible(true);
			}
		});
		btnQuit.setBounds(230, 237, 89, 23);
		panelGame.add(btnQuit);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerOne.resetScore();
				playerTwo.resetScore();
				game.setCurrentRound(1);
				//btnRoll.setVisible(true);
				refreshGameLabels();
				btnContinue.setVisible(false);	
				System.out.println("Button CONTINUE");
			}
		});
		
		btnContinue.setBounds(131, 237, 89, 23);
		panelGame.add(btnContinue);
		btnContinue.setVisible(false);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds()) {
					
					if (game.getRounds()==game.getRound()){
						game.newRound();
						lblCurrentRound.setText("Round Over! Winner: " + game.getGameWinner(Integer.parseInt(textRoundBet.getText())).getName());
						btnContinue.setVisible(true);
						System.out.println("Button ELSE");
					}
					else if(game.newRound()){
						System.out.println("Button IF");
						lblCurrentRound.setText("Round " + (game.getRound()-1));
					}
					refreshGameLabels();
				}
				else {
					btnRoll.setVisible(false);
					btnContinue.setVisible(false);
				}
			}
		});
		
		btnRoll.setBounds(131, 237, 89, 23);
		panelGame.add(btnRoll);

		btnStart.addActionListener(new ActionListener() {
			//START BUTTON This will update the players names, money and create a new game based on the combo box selections
			public void actionPerformed(ActionEvent e) {
				panelGame.setVisible(true);
				panelMain.setVisible(false);
				playerOne.name = txtPlayerOneName.getText();
				playerOne.money = Integer.parseInt(txtStartingFunds.getText());
				playerTwo.name = txtPlayerTwoName.getText();
				playerTwo.money = Integer.parseInt(txtStartingFunds.getText());
				game = new Game(Integer.parseInt(comboBoxRounds.getSelectedItem().toString()), comboBoxDice.getSelectedIndex()+1, playerOne, playerTwo);
				lblNamePlayerOne.setText(playerOne.getName());
				lblNamePlayerTwo.setText(playerTwo.getName());
				lblFundsPlayerOne.setText("$"+playerOne.getMoney());
				lblFundsPlayerTwo.setText("$"+playerTwo.getMoney());
				lblScorePlayerOne.setText(""+playerOne.getScore());
				lblScorePlayerTwo.setText(""+playerTwo.getScore());	
				btnRoll.setVisible(true);
			}
		});
		btnStart.setBounds(123, 239, 102, 22);
		panelMain.add(btnStart);
	}
	
	//Initialize the contents of the frame
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("I Can't Wait To Dice!");
		frame.setBounds(100, 100, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		this.initializeMainMenu();
		this.initializeGameMenu();
	}
		
	public static void coinImage() {
		//called from Game.getRoundWinner()
		JPanel panelCoin = new JPanel();
		panelCoin.setBounds(157, 53, 135, 129);
		WindowGUI.frame.add(panelCoin);
		//ImageIcon coinGif = new ImageIcon(WindowGUI.getResource("coinflip.gif"));
		ImageIcon coinGif = new ImageIcon(WindowGUI.class.getResource("coinflip.gif"));
		JLabel coinLabel = new JLabel(coinGif);
		panelCoin.add(coinLabel);
		panelCoin.setVisible(true);
		coinLabel.setVisible(true);	
	}
	
	//Updates Labels in Game Panel to match players values
	public void refreshGameLabels() {
		lblNamePlayerOne.setText(playerOne.getName());
		lblNamePlayerTwo.setText(playerTwo.getName());
		lblFundsPlayerOne.setText("$"+playerOne.getMoney());
		lblFundsPlayerTwo.setText("$"+playerTwo.getMoney());
		lblScorePlayerOne.setText(""+playerOne.getScore());
		lblScorePlayerTwo.setText(""+playerTwo.getScore());
	}
}