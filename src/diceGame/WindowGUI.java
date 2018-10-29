package diceGame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class WindowGUI {

	private JFrame frame;
	private JTextField txtPlayer;
	private JTextField txtPlayer_1;
	private JTextField textField;
	private final JButton btnStart = new JButton("Start");
	
	private static String[] diceNumbers = {"1", "2", "3", "4", "5"};
	private static Integer[] roundNumbers = {1, 3, 5};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowGUI window = new WindowGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 271);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 434, 271);
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		panel1.setVisible(true);
				
		JLabel lblPlayer = new JLabel("Player 1");
		lblPlayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer.setBounds(21, 11, 46, 14);
		panel.add(lblPlayer);
		
		JLabel lblNamep = new JLabel("Namep1");
		lblNamep.setBounds(21, 28, 46, 14);
		panel.add(lblNamep);
		
		JLabel lblPlayer_1 = new JLabel("Player 2");
		lblPlayer_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayer_1.setBounds(378, 11, 46, 14);
		panel.add(lblPlayer_1);
		
		JLabel lblNamep_1 = new JLabel("Namep2");
		lblNamep_1.setBounds(378, 28, 46, 14);
		panel.add(lblNamep_1);
		
		JLabel lblFundsp = new JLabel("Fundsp1");
		lblFundsp.setBounds(21, 53, 46, 14);
		panel.add(lblFundsp);
		
		JLabel lblFundsp_1 = new JLabel("Fundsp2");
		lblFundsp_1.setBounds(378, 53, 46, 14);
		panel.add(lblFundsp_1);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(21, 78, 46, 14);
		panel.add(lblScore);
		
		JLabel lblPScore = new JLabel("P1 SCore");
		lblPScore.setBounds(57, 78, 46, 14);
		panel.add(lblPScore);
		
		JLabel lblScore_1 = new JLabel("Score: ");
		lblScore_1.setBounds(343, 78, 46, 14);
		panel.add(lblScore_1);
		
		JLabel lblPscore = new JLabel("p2SCore");
		lblPscore.setBounds(378, 78, 46, 14);
		panel.add(lblPscore);
		
		JLabel lblDiceGame = new JLabel("Dice Game - New Game", SwingConstants.CENTER);		
		lblDiceGame.setBounds(0, 0, 434, 25);
		lblDiceGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel1.add(lblDiceGame);
		
		JLabel lblPlayerName = new JLabel("Player 1 Name:");
		lblPlayerName.setBounds(97, 52, 99, 14);
		panel1.add(lblPlayerName);
		
		JLabel lblPlayerName_1 = new JLabel("Player 2 Name:");
		lblPlayerName_1.setBounds(97, 77, 109, 14);
		panel1.add(lblPlayerName_1);
		
		JLabel lblNumberOfDice = new JLabel("Number of Dice:");
		lblNumberOfDice.setBounds(97, 121, 123, 14);
		panel1.add(lblNumberOfDice);
		
		JLabel lblNumberOfRounds = new JLabel("Number of Rounds:");
		lblNumberOfRounds.setBounds(97, 146, 123, 14);
		panel1.add(lblNumberOfRounds);
		
		JLabel lblPlayerStartingMoney = new JLabel("Player starting Money:");
		lblPlayerStartingMoney.setBounds(97, 185, 155, 14);
		panel1.add(lblPlayerStartingMoney);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel1.setVisible(true);
			}
		});
		btnQuit.setBounds(230, 237, 89, 23);
		panel.add(btnQuit);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRoll.setBounds(131, 237, 89, 23);
		panel.add(btnRoll);
		
		txtPlayer = new JTextField();
		txtPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer.setText("Player 1");
		txtPlayer.setBounds(216, 49, 112, 20);
		panel1.add(txtPlayer);
		txtPlayer.setColumns(10);
		
		txtPlayer_1 = new JTextField();
		txtPlayer_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayer_1.setText("Player 2");
		txtPlayer_1.setBounds(216, 74, 112, 20);
		panel1.add(txtPlayer_1);
		txtPlayer_1.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(252, 118, 40, 20);
		panel1.add(comboBox);
		
		JComboBox<Integer> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(252, 143, 40, 20);
		panel1.add(comboBox_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("0");
		textField.setBounds(262, 182, 66, 20);
		panel1.add(textField);
		textField.setColumns(10);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel1.setVisible(false);
			}
		});
		btnStart.setBounds(123, 239, 102, 22);
		panel1.add(btnStart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(230, 239, 99, 22);
		panel1.add(btnExit);
	}
}
