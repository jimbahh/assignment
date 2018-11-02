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
import javax.swing.JFrame;
import javax.swing.ImageIcon;


public class MainMenu extends Frame {
	//Main Menu Panel Variables
	private JTextField txtPlayerOneName;
	private JTextField txtPlayerTwoName;
	private JTextField txtStartingFunds;
	private static JButton btnStart = new JButton("Start");
	JButton btnExit = new JButton("Exit");
	private static String[] diceNumbers = {"1", "2", "3", "4", "5"};
	private static Integer[] roundNumbers = {1, 3, 5};
	private JPanel panelMain = new JPanel();
	JComboBox<String> comboBoxDice = new JComboBox<String>(diceNumbers);
	JComboBox<Integer> comboBoxRounds = new JComboBox<Integer>(roundNumbers);
	//DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(diceNumbers);
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	//JComboBox comboBoxDice = new JComboBox(comboModel);
	//DefaultComboBoxModel<Integer> comboModel1 = new DefaultComboBoxModel<Integer>(roundNumbers);
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	//JComboBox comboBoxRounds= new JComboBox(comboModel);
	
	//M
	 void initializeMainMenu() {
			panelMain.setBounds(0, 0, 434, 271);
			panelMain.setLayout(null);
			panelMain.setVisible(true);
			frame.getContentPane().add(panelMain);
	 }

		
		
	 //M
	 void initializeLblDiceGame() {
		lblDiceGame.setBounds(0, 11, 434, 25);
		lblDiceGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiceGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		panelMain.add(lblDiceGame);
	}
	 
	//M
	 void initializePlayerNameLabels() {
		JLabel lblPlayerOneName = new JLabel("Player 1 Name:");
		lblPlayerOneName.setBounds(97, 52, 99, 14);
		panelMain.add(lblPlayerOneName);
		
		JLabel lblPlayerTwoName = new JLabel("Player 2 Name:");
		lblPlayerTwoName.setBounds(97, 77, 109, 14);
		panelMain.add(lblPlayerTwoName);
	}
	 
	 //M
	 void initializeNumberDiceLbl() {
	JLabel lblNumberOfDice = new JLabel("Number of Dice:");
		lblNumberOfDice.setBounds(97, 121, 123, 14);
		panelMain.add(lblNumberOfDice);
	}
	 
	//M
	 void initializeNumberRoundsLbl() {
		JLabel lblNumberOfRounds = new JLabel("Number of Rounds:");
		lblNumberOfRounds.setBounds(97, 146, 123, 14);
		panelMain.add(lblNumberOfRounds);
	}
	
	 //M
	 void initializeStartMoneyLbl() {
		JLabel lblPlayerStartingMoney = new JLabel("Player starting Money:");
		lblPlayerStartingMoney.setBounds(97, 185, 155, 14);
		panelMain.add(lblPlayerStartingMoney);
	}
	
	 //M
	 void initializeNameTxts() {
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
	
	 //M
	 void initializeComboBoxDice() {
		comboBoxDice.setSelectedIndex(1);
		comboBoxDice.setBounds(242, 118, 40, 20);
		panelMain.add(comboBoxDice);
	}
	
	 //M
	 void initializeComboBoxRounds() {
		comboBoxRounds.setSelectedIndex(1);
		comboBoxRounds.setBounds(242, 143, 40, 20);
		panelMain.add(comboBoxRounds);
	}
	
	 //M
	 void initializeStartingMoneyTxt() {
		txtStartingFunds = new JTextField();
		txtStartingFunds.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartingFunds.setText("100");
		txtStartingFunds.setBounds(242, 182, 66, 20);
		panelMain.add(txtStartingFunds);
		txtStartingFunds.setColumns(10);
	}
	
	 //M
	 void initializebtnExit() {
		btnExit.setBounds(230, 239, 99, 22);
		panelMain.add(btnExit);
	}
		//<
	 void btnExit() {
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	 //M
	 void initializeStartBtn() {
		btnStart.setBounds(123, 239, 102, 22);
		panelMain.add(btnStart);
	}
	 
	//M
	void btnStart() {
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
	
//M
	//Updates Labels in Game Panel to match players values
	void refreshGameLabels() {
		lblNamePlayerOne.setText(playerOne.getName());
		lblNamePlayerTwo.setText(playerTwo.getName());
		lblFundsPlayerOne.setText("$"+playerOne.getMoney());
		lblFundsPlayerTwo.setText("$"+playerTwo.getMoney());
		lblScorePlayerOne.setText(""+playerOne.getScore());
		lblScorePlayerTwo.setText(""+playerTwo.getScore());
	}
}