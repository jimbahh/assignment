package diceGame;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class WindowGUI {
	
	static JFrame frame = Frame.getInstance();
	static GameMenu gameMenu;
	static MainMenu mainMenu;
	
	//Launches the App
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new WindowGUI();
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
		mainMenu = new MainMenu();
		gameMenu = new GameMenu();		
	}
	
}
		
	
