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
	static PlayerOne playerOne = PlayerOne.getInstance();
	static PlayerTwo playerTwo = PlayerTwo.getInstance();
	
	//Main Menu Panel Variables
	private JTextField txtPlayerOneName;
	private JTextField txtPlayerTwoName;
	private JTextField txtStartingFunds;
	private static JButton btnStart = new JButton("Start");
	private static String[] diceNumbers = {"1", "2", "3", "4", "5"};
	private static Integer[] roundNumbers = {1, 3, 5};
	private JTextField textRoundBet;
	private JPanel panelMain;
	JComboBox<String> comboBoxDice = new JComboBox<String>(diceNumbers);
	JComboBox<Integer> comboBoxRounds = new JComboBox<Integer>(roundNumbers);
	//DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(diceNumbers);
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	//JComboBox comboBoxDice = new JComboBox(comboModel);
	//DefaultComboBoxModel<Integer> comboModel1 = new DefaultComboBoxModel<Integer>(roundNumbers);
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	//JComboBox comboBoxRounds= new JComboBox(comboModel);
	
	//Game Panel Variables
	static JPanel panelGame;
	static JPanel panelCoin = new JPanel();
	JButton btnRoll = new JButton("Roll");
	JButton btnQuit = new JButton("Quit");
	JButton btnContinue = new JButton("Continue");
	JButton btnExit = new JButton("Exit");
	JLabel lblNamePlayerOne;
	JLabel lblNamePlayerTwo;
	JLabel lblFundsPlayerOne;
	JLabel lblFundsPlayerTwo;
	JLabel lblScorePlayerOne;
	JLabel lblScorePlayerTwo;
	static JLabel lblCurrentRound = new JLabel();
	static JLabel lblDraw = new JLabel("Draw! Flipping a coin!");
	static JLabel lblDiceGame = new JLabel("New Game");		
	static JLabel lblRoundBet = new JLabel("Round Bet:");


	
	//Launches the App
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	
	private void initialize() {
		this.initializeFrame();
		this.initializeMainMenu();
		this.initializeNameLabels();
		this.initializeFundLabels();
		this.initializeScoreLabels();
		this.initializeCurrentRoundLbl();
		this.initializeBetLabel();
		this.initializeBtnQuit();
		this.initializeBtnContinue();
		this.initializeRollBtn();
		this.initializeRoundBetLbl();
		this.initializeLblDiceGame();
		this.initializePlayerNameLabels();
		this.initializeNumberDiceLbl();
		this.initializeNumberRoundsLbl();
		this.initializeStartMoneyLbl();
		this.initializeNameTxts();
		this.initializeComboBoxDice();
		this.initializeComboBoxRounds();
		this.initializeStartingMoneyTxt();
		this.initializeStartBtn();
		this.initializebtnExit();
		this.btnRoll();
		this.btnQuit();
		this.btnContinue();
		this.btnStart();
		this.btnExit();
	}
	
	//Initialize the contents of the frame
	private void initializeFrame() {
		frame = new JFrame();
		frame.setTitle("I Can't Wait To Dice!");
		frame.setBounds(100, 100, 450, 310);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	public void initializeMainMenu() {
		panelGame = new JPanel();
		panelGame.setBounds(0, 0, 434, 271);
		frame.getContentPane().add(panelGame);
		panelGame.setLayout(null);
		panelGame.setVisible(false);
	}
	
	public void initializeNameLabels() {		
		lblNamePlayerOne = new JLabel("");
		lblNamePlayerOne.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNamePlayerOne.setHorizontalAlignment(SwingConstants.LEFT);
		lblNamePlayerOne.setBounds(10, 27, 89, 14);
		panelGame.add(lblNamePlayerOne);
		
		lblNamePlayerTwo = new JLabel("");
		lblNamePlayerTwo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNamePlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNamePlayerTwo.setBounds(335, 27, 89, 14);
		panelGame.add(lblNamePlayerTwo);
	}
	
	public void initializeFundLabels() {		
		lblFundsPlayerOne = new JLabel("");
		lblFundsPlayerOne.setBounds(10, 52, 46, 14);
		panelGame.add(lblFundsPlayerOne);
		
		lblFundsPlayerTwo = new JLabel("");
		lblFundsPlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFundsPlayerTwo.setBounds(378, 52, 46, 14);
		panelGame.add(lblFundsPlayerTwo);
	}
		
	
	public void initializeScoreLabels() {
		lblScorePlayerOne = new JLabel("0");
		lblScorePlayerOne.setBounds(10, 77, 46, 14);
		panelGame.add(lblScorePlayerOne);
		
		lblScorePlayerTwo = new JLabel("0");
		lblScorePlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScorePlayerTwo.setBounds(378, 77, 36, 14);
		panelGame.add(lblScorePlayerTwo);
	}
	
	public void initializeCurrentRoundLbl() {
		
		lblCurrentRound.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentRound.setBounds(10, 0, 414, 25);
		panelGame.add(lblCurrentRound);
	}
	
	public void initializeBetLabel() {
		lblRoundBet.setBounds(143, 241, 95, 14);
	}
	
	public void initializeRoundBetLbl() {
		panelGame.add(lblRoundBet);
		textRoundBet = new JTextField();
		textRoundBet.setHorizontalAlignment(SwingConstants.CENTER);
		textRoundBet.setText("10");
		textRoundBet.setBounds(248, 238, 46, 20);
		panelGame.add(textRoundBet);
		textRoundBet.setColumns(10);
	}
		
	public void initializeBtnQuit() {
		btnQuit.setBounds(335, 237, 89, 23);
		panelGame.add(btnQuit);
	}
	
	public void btnQuit() {
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelGame.setVisible(false);
				panelMain.setVisible(true);
			}
		});
	}
		
	public void initializeBtnContinue() {
		btnContinue.setBounds(10, 237, 89, 23);
		panelGame.add(btnContinue);
		btnContinue.setVisible(false);
	}
	
	public void btnContinue() {
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				coinOff();
				playerOne.resetScore();
				playerTwo.resetScore();
				game.setCurrentRound(1);
				//btnRoll.setVisible(true);
				refreshGameLabels();
				btnContinue.setVisible(false);	
				System.out.println("Button CONTINUE");
			}
		});
	}
	
	public void initializeRollBtn()	{
		btnRoll.setBounds(10, 237, 89, 23);
		panelGame.add(btnRoll);
		panelMain = new JPanel();
		panelMain.setBounds(0, 0, 434, 271);
		frame.getContentPane().add(panelMain);
		panelMain.setLayout(null);
		panelMain.setVisible(true);
			}
		
	public void btnRoll() {
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds()) {
					coinOff();
					if (game.getRounds()==game.getRound()){
						game.newRound();
						lblCurrentRound.setText("Game Over! " + game.getBetWinner(Integer.parseInt(textRoundBet.getText())).getName() + " wins!");
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
	}
		
	public void initializeLblDiceGame() {
		lblDiceGame.setBounds(0, 11, 434, 25);
		lblDiceGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelMain.add(lblDiceGame);
	}
		
	public void initializePlayerNameLabels() {
		JLabel lblPlayerOneName = new JLabel("Player 1 Name:");
		lblPlayerOneName.setBounds(97, 52, 99, 14);
		panelMain.add(lblPlayerOneName);
		
		JLabel lblPlayerTwoName = new JLabel("Player 2 Name:");
		lblPlayerTwoName.setBounds(97, 77, 109, 14);
		panelMain.add(lblPlayerTwoName);
	}

	public void initializeNumberDiceLbl() {
	JLabel lblNumberOfDice = new JLabel("Number of Dice:");
		lblNumberOfDice.setBounds(97, 121, 123, 14);
		panelMain.add(lblNumberOfDice);
	}
	
	public void initializeNumberRoundsLbl() {
		
		JLabel lblNumberOfRounds = new JLabel("Number of Rounds:");
		lblNumberOfRounds.setBounds(97, 146, 123, 14);
		panelMain.add(lblNumberOfRounds);
	}
	
	public void initializeStartMoneyLbl() {
		JLabel lblPlayerStartingMoney = new JLabel("Player starting Money:");
		lblPlayerStartingMoney.setBounds(97, 185, 155, 14);
		panelMain.add(lblPlayerStartingMoney);
	}
	
	public void initializeNameTxts() {
		
		txtPlayerOneName = new JTextField();
		txtPlayerOneName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerOneName.setText("Player 1");
		txtPlayerOneName.setBounds(242, 47, 112, 20);
		panelMain.add(txtPlayerOneName);
		txtPlayerOneName.setColumns(10);
		
		txtPlayerTwoName = new JTextField();
		txtPlayerTwoName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerTwoName.setText("Player 2");
		txtPlayerTwoName.setBounds(242, 74, 112, 20);
		panelMain.add(txtPlayerTwoName);
		txtPlayerTwoName.setColumns(10);
	}
	
	public void initializeComboBoxDice() {
		
		comboBoxDice.setSelectedIndex(1);
		comboBoxDice.setBounds(242, 118, 40, 20);
		panelMain.add(comboBoxDice);
	}
	
	public void initializeComboBoxRounds() {
		
		comboBoxRounds.setSelectedIndex(1);
		comboBoxRounds.setBounds(242, 143, 40, 20);
		panelMain.add(comboBoxRounds);
	}
	
	public void initializeStartingMoneyTxt() {
		
		txtStartingFunds = new JTextField();
		txtStartingFunds.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartingFunds.setText("100");
		txtStartingFunds.setBounds(242, 182, 66, 20);
		panelMain.add(txtStartingFunds);
		txtStartingFunds.setColumns(10);
	}
	
	public void initializebtnExit() {
		btnExit.setBounds(230, 239, 99, 22);
		panelMain.add(btnExit);
	}
		
	public void btnExit() {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void initializeStartBtn() {
		btnStart.setBounds(123, 239, 102, 22);
		panelMain.add(btnStart);
	}
	
	public void btnStart() {
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
				refreshGameLabels();
				btnRoll.setVisible(true);
			}
		});
		
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
		
	public static void coinImage() {
		lblDraw();
		panelCoin.setBounds(157, 53, 135, 129);
		WindowGUI.frame.getContentPane().add(panelCoin);
		ImageIcon coinGif = new ImageIcon(WindowGUI.class.getResource("coinflip.gif"));
		JLabel coinLabel = new JLabel(coinGif);
		panelCoin.add(coinLabel);
		panelCoin.setVisible(true);
		coinLabel.setVisible(true);
	}
	
	public static void lblDraw() {
		panelGame.add(lblDraw);
		lblDraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblDraw.setBounds(10, 0, 414, 25);
		lblCurrentRound.setVisible(false);
		lblDraw.setVisible(true);
	}
	
	public static void coinOff() {
		panelCoin.setVisible(false);	
		lblDraw.setVisible(false);
		lblCurrentRound.setVisible(true);
	}
	
}
		
	
