package diceGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainMenu extends Menu {
	
	//Main Menu Panel Variables
	protected static JTextField txtPlayerOneName;
	protected static JTextField txtPlayerTwoName;
	protected static JTextField txtStartingFunds;
	protected static JButton btnStart = new JButton("Start");
	static JButton btnExit = new JButton("Exit");
	private static String[] diceNumbers = {"1", "2", "3", "4", "5"};
	private static Integer[] roundNumbers = {1, 3, 5};
	protected static JPanel panelMain = new JPanel();
	static JComboBox<String> comboBoxDice = new JComboBox<String>(diceNumbers);
	static JComboBox<Integer> comboBoxRounds = new JComboBox<Integer>(roundNumbers);
	
	static void initializeAllMain() {
		initializeMainMenu();
		initializeLblDiceGame();
		initializePlayerNameLabels();
		initializeNumberDiceLbl();
		initializeNumberRoundsLbl();
		initializeStartMoneyLbl();
		initializeNameTxts();
		initializeComboBoxDice();
		initializeComboBoxRounds();
		initializeStartingMoneyTxt();
		initializeStartBtn();
		initializebtnExit();
		btnStart();
		btnExit();	
	}
	
	 static void initializeMainMenu() {
			panelMain.setBounds(0, 0, 434, 271);
			panelMain.setLayout(null);
			panelMain.setVisible(true);
			frame.add(panelMain);
	 }
	 
	static void menuVisible() {
			panelMain.setVisible(true);
		}
		
	static void menuInvisible() {
			panelMain.setVisible(false);
		}

	static void initializeLblDiceGame() {
		lblDiceGame.setBounds(0, 11, 434, 25);
		lblDiceGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelMain.add(lblDiceGame);
	}
	 
	static void initializePlayerNameLabels() {
		JLabel lblPlayerOneName = new JLabel("Player 1 Name:");
		lblPlayerOneName.setBounds(97, 52, 99, 14);
		panelMain.add(lblPlayerOneName);
		
		JLabel lblPlayerTwoName = new JLabel("Player 2 Name:");
		lblPlayerTwoName.setBounds(97, 77, 109, 14);
		panelMain.add(lblPlayerTwoName);
	}
	 
	static void initializeNumberDiceLbl() {
	JLabel lblNumberOfDice = new JLabel("Number of Dice:");
		lblNumberOfDice.setBounds(97, 121, 123, 14);
		panelMain.add(lblNumberOfDice);
	}
	 
	static void initializeNumberRoundsLbl() {
		JLabel lblNumberOfRounds = new JLabel("Number of Rounds:");
		lblNumberOfRounds.setBounds(97, 146, 123, 14);
		panelMain.add(lblNumberOfRounds);
	}
	 
	static void initializeStartMoneyLbl() {
		JLabel lblPlayerStartingMoney = new JLabel("Player starting Money:");
		lblPlayerStartingMoney.setBounds(97, 185, 155, 14);
		panelMain.add(lblPlayerStartingMoney);
	}
	 
	static void initializeNameTxts() {
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
	
	static void initializeComboBoxDice() {
		comboBoxDice.setSelectedIndex(1);
		comboBoxDice.setBounds(242, 118, 40, 20);
		panelMain.add(comboBoxDice);
	}
	
	  
	static void initializeComboBoxRounds() {
		comboBoxRounds.setSelectedIndex(1);
		comboBoxRounds.setBounds(242, 143, 40, 20);
		panelMain.add(comboBoxRounds);
	}
	
	  
	static void initializeStartingMoneyTxt() {
		txtStartingFunds = new JTextField();
		txtStartingFunds.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartingFunds.setText("100");
		txtStartingFunds.setBounds(242, 182, 66, 20);
		panelMain.add(txtStartingFunds);
		txtStartingFunds.setColumns(10);
	}
	
	  
	static void initializebtnExit() {
		btnExit.setBounds(230, 239, 99, 22);
		panelMain.add(btnExit);
	}
		//<
	 static void btnExit() {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	  
	static void initializeStartBtn() {
		btnStart.setBounds(123, 239, 102, 22);
		panelMain.add(btnStart);
	}
	 
	 
	static void btnStart() {
		btnStart.addActionListener(new ActionListener() {
			//START BUTTON This will update the players names, money and create a new game based on the combo box selections
			public void actionPerformed(ActionEvent e) {
				GameMenu.gameVisible();
				menuInvisible();
				playerOne.name = txtPlayerOneName.getText();
				playerOne.money = Integer.parseInt(txtStartingFunds.getText());
				playerTwo.name = txtPlayerTwoName.getText();
				playerTwo.money = Integer.parseInt(txtStartingFunds.getText());
				game = new Game(Integer.parseInt(comboBoxRounds.getSelectedItem().toString()), comboBoxDice.getSelectedIndex()+1, playerOne, playerTwo);
				refreshGameLabels();
				GameMenu.btnRoll.setVisible(true);
			}
		});
		
	}
	
	 
	//Updates Labels in Game Panel to match players values
	static void refreshGameLabels() {
		lblNamePlayerOne.setText(playerOne.getName());
		lblNamePlayerTwo.setText(playerTwo.getName());
		lblFundsPlayerOne.setText("$"+playerOne.getMoney());
		lblFundsPlayerTwo.setText("$"+playerTwo.getMoney());
		lblScorePlayerOne.setText(""+playerOne.getScore());
		lblScorePlayerTwo.setText(""+playerTwo.getScore());
	}
}
