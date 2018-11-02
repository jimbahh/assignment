package diceGame;

import javax.swing.JFrame;

public class Frame {
	private static JFrame frame = new JFrame();
	
	public static JFrame getInstance() {
        return frame;
}
	//Initialize the contents of the frame
	static void initializeFrame() {
		frame.setTitle("I Can't Wait To Dice!");
		frame.setBounds(100, 100, 450, 310);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}

	static void frameVisible() {
		frame.setVisible(true);
	}

	static void setLocationRelativeTo() {
		frame.setLocationRelativeTo(null);
		
	}
	
}
