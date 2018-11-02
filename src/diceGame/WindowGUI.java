package diceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;



public class WindowGUI {
	
	private static WindowGUI gui = new WindowGUI();
	static JFrame frame = Frame.getInstance();
	
	public static WindowGUI getInstance() {
	        return gui;
	}

	
	//Launches the App
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getInstance();
					frame.setVisible(true);
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
		Frame.initializeFrame();
		MainMenu.initializeMainMenu();
		MainMenu.initializeLblDiceGame();
		MainMenu.initializePlayerNameLabels();
		MainMenu.initializeNumberDiceLbl();
		MainMenu.initializeNumberRoundsLbl();
		MainMenu.initializeStartMoneyLbl();
		MainMenu.initializeNameTxts();
		MainMenu.initializeComboBoxDice();
		MainMenu.initializeComboBoxRounds();
		MainMenu.initializeStartingMoneyTxt();
		MainMenu.initializeStartBtn();
		MainMenu.initializebtnExit();
		MainMenu.btnStart();
		MainMenu.btnExit();
		
		GameMenu.initializeGameMenu();
		GameMenu.initializeNameLabels();
		GameMenu.initializeFundLabels();
		GameMenu.initializeScoreLabels();
		GameMenu.initializeCurrentRoundLbl();
		GameMenu.initializeBetLabel();
		GameMenu.initializeBtnQuit();
		GameMenu.initializeBtnContinue();
		GameMenu.initializeRollBtn();
		GameMenu.initializeRoundBetLbl();
		GameMenu.btnRoll();
		GameMenu.btnQuit();
		GameMenu.btnContinue();
		
		
		
	}
	
}
		
	
