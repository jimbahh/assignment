package diceGame;

import java.awt.EventQueue;



public class WindowGUI {
	
	//WindowGUI Variables

	
	//Launches the App
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new WindowGUI();
					Frame.setVisible();
					Frame.setLocationRelativeTo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Creates the Window
//	public WindowGUI() {
	//	initialize();
//	}
	
	/*private void initialize() {
		this.initializeFrame();
		this.initializeMainMenu();
		this.initializeGameMenu();
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
	*/
}
		
	
