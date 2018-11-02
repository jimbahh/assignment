package diceGame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JFrame;

import javax.swing.JComboBox;


public class GameMenu extends Frame {
	//Game Panel Variables
	static JPanel panelGame = new JPanel();
	static JPanel panelCoin = new JPanel();
	JButton btnRoll = new JButton("Roll");
	JButton btnQuit = new JButton("Quit");
	JButton btnContinue = new JButton("Continue");
	static JLabel lblCurrentRound = new JLabel();
	static JLabel lblDraw = new JLabel("Draw! Flipping a coin!");
	static JLabel lblRoundBet = new JLabel("Round Bet:");
	private JTextField textRoundBet;

	void gameVisible() {
		panelGame.setVisible(true);
	}
	
	void gameInvisible() {
		panelGame.setVisible(false);
	}
	
	//G
		 void initializeGameMenu() {
			panelGame.setBounds(0, 0, 434, 271);
			frame.getContentPane().add(panelGame);
			panelGame.setLayout(null);
			gameInvisible();
			}
		 
		//G
		 void initializeNameLabels() {		
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
		//G
		 void initializeFundLabels() {		
			lblFundsPlayerOne = new JLabel("");
			lblFundsPlayerOne.setBounds(10, 52, 46, 14);
			panelGame.add(lblFundsPlayerOne);
			
			lblFundsPlayerTwo = new JLabel("");
			lblFundsPlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFundsPlayerTwo.setBounds(378, 52, 46, 14);
			panelGame.add(lblFundsPlayerTwo);
		}
			
		//G
		 void initializeScoreLabels() {
			lblScorePlayerOne = new JLabel("0");
			lblScorePlayerOne.setBounds(10, 77, 46, 14);
			panelGame.add(lblScorePlayerOne);
			
			lblScorePlayerTwo = new JLabel("0");
			lblScorePlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblScorePlayerTwo.setBounds(378, 77, 36, 14);
			panelGame.add(lblScorePlayerTwo);
		}
		 
		//G
		 void initializeCurrentRoundLbl() {
			
			lblCurrentRound.setHorizontalAlignment(SwingConstants.CENTER);
			lblCurrentRound.setBounds(10, 0, 414, 25);
			panelGame.add(lblCurrentRound);
		}
		 
		//G
		 void initializeBetLabel() {
			lblRoundBet.setBounds(143, 241, 95, 14);
		}
		
		 //G
		void initializeRoundBetLbl() {
			panelGame.add(lblRoundBet);
			textRoundBet = new JTextField();
			textRoundBet.setHorizontalAlignment(SwingConstants.CENTER);
			textRoundBet.setText("10");
			textRoundBet.setBounds(248, 238, 46, 20);
			panelGame.add(textRoundBet);
			textRoundBet.setColumns(10);
		}
		
		//G	
		void initializeBtnQuit() {
			btnQuit.setBounds(335, 237, 89, 23);
			panelGame.add(btnQuit);
		}
		
		//G
		 void btnQuit() {
			btnQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelGame.setVisible(false);
					panelMain.setVisible(true);
				}
			});
		}
		 //G
		 void initializeBtnContinue() {
			btnContinue.setBounds(10, 237, 89, 23);
			panelGame.add(btnContinue);
			btnContinue.setVisible(false);
		}
		
		 //G
		 void btnContinue() {
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
		
		 //G
		 void initializeRollBtn()	{
			btnRoll.setBounds(10, 237, 89, 23);
			panelGame.add(btnRoll);	
				}
			
		//G
		 void btnRoll() {
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

			//C or G?
			 static void coinImage() {
				lblDraw();
				panelCoin.setBounds(157, 53, 135, 129);
				Frame.getContentPane().add(panelCoin);
				ImageIcon coinGif = new ImageIcon(WindowGUI.class.getResource("coinflip.gif"));
				JLabel coinLabel = new JLabel(coinGif);
				panelCoin.add(coinLabel);
				panelCoin.setVisible(true);
				coinLabel.setVisible(true);
			}
			 
			 //C or G?
			
			 static void lblDraw() {
				panelGame.add(lblDraw);
				lblDraw.setHorizontalAlignment(SwingConstants.CENTER);
				lblDraw.setBounds(10, 0, 414, 25);
				lblCurrentRound.setVisible(false);
				lblDraw.setVisible(true);
			}
			
			 //C or G?
			public static void coinOff() {
				panelCoin.setVisible(false);	
				lblDraw.setVisible(false);
				lblCurrentRound.setVisible(true);
			}
			
		}
}
