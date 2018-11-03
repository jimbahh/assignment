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
	private JTextField txtPlayerOneName;
	private JTextField txtPlayerTwoName;
	private JTextField txtStartingFunds;
	private JButton btnStart = new JButton("Start");
	private JButton btnExit = new JButton("Exit");
	private String[] diceNumbers = {"1", "2", "3", "4", "5"};
	private Integer[] roundNumbers = {1, 3, 5};
	private JPanel panelMain;
	private JComboBox<String> comboBoxDice = new JComboBox<String>(diceNumbers);
	private JComboBox<Integer> comboBoxRounds = new JComboBox<Integer>(roundNumbers);
	
	public MainMenu() {
		panelMain = new JPanel();
		this.initializeAllMain();
	}
	
	private void initializeAllMain() {
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
	
	 private void initializeMainMenu() {
			panelMain.setBounds(0, 0, 434, 271);
			panelMain.setLayout(null);
			panelMain.setVisible(true);
			frame.add(panelMain);
	 }
	 
	public void menuVisible(boolean value) {
			panelMain.setVisible(value);
		}
		
	private void initializeLblDiceGame() {
		lblDiceGame.setBounds(0, 11, 434, 25);
		lblDiceGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelMain.add(lblDiceGame);
	}
	 
	private void initializePlayerNameLabels() {
		JLabel lblPlayerOneName = new JLabel("Player 1 Name:");
		lblPlayerOneName.setBounds(97, 52, 99, 14);
		panelMain.add(lblPlayerOneName);
		
		JLabel lblPlayerTwoName = new JLabel("Player 2 Name:");
		lblPlayerTwoName.setBounds(97, 77, 109, 14);
		panelMain.add(lblPlayerTwoName);
	}
	 
	private void initializeNumberDiceLbl() {
	JLabel lblNumberOfDice = new JLabel("Number of Dice:");
		lblNumberOfDice.setBounds(97, 121, 123, 14);
		panelMain.add(lblNumberOfDice);
	}
	 
	private void initializeNumberRoundsLbl() {
		JLabel lblNumberOfRounds = new JLabel("Number of Rounds:");
		lblNumberOfRounds.setBounds(97, 146, 123, 14);
		panelMain.add(lblNumberOfRounds);
	}
	 
	private void initializeStartMoneyLbl() {
		JLabel lblPlayerStartingMoney = new JLabel("Player starting Money:");
		lblPlayerStartingMoney.setBounds(97, 185, 155, 14);
		panelMain.add(lblPlayerStartingMoney);
	}
	 
	private void initializeNameTxts() {
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
	
	private void initializeComboBoxDice() {
		comboBoxDice.setSelectedIndex(1);
		comboBoxDice.setBounds(242, 118, 40, 20);
		panelMain.add(comboBoxDice);
	}
	
	  
	private void initializeComboBoxRounds() {
		comboBoxRounds.setSelectedIndex(1);
		comboBoxRounds.setBounds(242, 143, 40, 20);
		panelMain.add(comboBoxRounds);
	}
	
	  
	private void initializeStartingMoneyTxt() {
		txtStartingFunds = new JTextField();
		txtStartingFunds.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartingFunds.setText("100");
		txtStartingFunds.setBounds(242, 182, 66, 20);
		panelMain.add(txtStartingFunds);
		txtStartingFunds.setColumns(10);
	}
	
	  
	private void initializebtnExit() {
		btnExit.setBounds(230, 239, 99, 22);
		panelMain.add(btnExit);
	}
		//<
	private void btnExit() {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	  
	private void initializeStartBtn() {
		btnStart.setBounds(123, 239, 102, 22);
		panelMain.add(btnStart);
	}
	 
	 
	private void btnStart() {
		btnStart.addActionListener(new ActionListener() {
			//START BUTTON This will update the players names, money and create a new game based on the combo box selections
			public void actionPerformed(ActionEvent e) {
				WindowGUI.gameMenu.gameVisible(true);
				menuVisible(false);
				playerOne.name = txtPlayerOneName.getText();
				playerOne.money = Integer.parseInt(txtStartingFunds.getText());
				playerTwo.name = txtPlayerTwoName.getText();
				playerTwo.money = Integer.parseInt(txtStartingFunds.getText());
				game = new Game(Integer.parseInt(comboBoxRounds.getSelectedItem().toString()), comboBoxDice.getSelectedIndex()+1, playerOne, playerTwo);
				WindowGUI.gameMenu.refreshGameLabels();
				WindowGUI.gameMenu.rollButtonSetVisible(true);
			}
		});
		
	}
	
	 
	//Updates Labels in Game Panel to match players values
	
}
