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
		MainMenu.initializeAllMain();
		GameMenu.initializeAllGame();		
	}
	
}
		
	
