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

public class GameMenu extends Menu {
	//Game Panel Variables
	static JPanel panelGame = new JPanel();
	static JPanel panelCoin = new JPanel();
	static JButton btnRoll = new JButton("Roll");
	static JButton btnQuit = new JButton("Quit");
	static JButton btnContinue = new JButton("Continue");
	static JLabel lblCurrentRound = new JLabel();
	static JLabel lblDraw = new JLabel("Draw! Flipping a coin!");
	static JLabel lblRoundBet = new JLabel("Round Bet:");
	public static JTextField textRoundBet;
	
	static void initializeAllGame() {
		initializeGameMenu();
		initializeNameLabels();
		initializeFundLabels();
		initializeScoreLabels();
		initializeCurrentRoundLbl();
		initializeBetLabel();
		initializeBtnQuit();
		initializeBtnContinue();
		initializeRollBtn();
		initializeRoundBetLbl();
		btnRoll();
		btnQuit();
		btnContinue();
	}

	static void gameVisible() {
			panelGame.setVisible(true);
		}
		
	static void gameInvisible() {
			panelGame.setVisible(false);
		}
	
	//G
	
	static void initializeGameMenu() {
			panelGame.setBounds(0, 0, 434, 271);
			frame.getContentPane().add(panelGame);
			panelGame.setLayout(null);
			gameInvisible();
			}
		 
		//G
	static void initializeNameLabels() {		
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
	static void initializeFundLabels() {		
			lblFundsPlayerOne = new JLabel("");
			lblFundsPlayerOne.setBounds(10, 52, 46, 14);
			panelGame.add(lblFundsPlayerOne);
			
			lblFundsPlayerTwo = new JLabel("");
			lblFundsPlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFundsPlayerTwo.setBounds(378, 52, 46, 14);
			panelGame.add(lblFundsPlayerTwo);
		}
			
		//G
	static void initializeScoreLabels() {
			lblScorePlayerOne = new JLabel("0");
			lblScorePlayerOne.setBounds(10, 77, 46, 14);
			panelGame.add(lblScorePlayerOne);
			
			lblScorePlayerTwo = new JLabel("0");
			lblScorePlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblScorePlayerTwo.setBounds(378, 77, 36, 14);
			panelGame.add(lblScorePlayerTwo);
		}
		 
		//G
	static void initializeCurrentRoundLbl() {
			
			lblCurrentRound.setHorizontalAlignment(SwingConstants.CENTER);
			lblCurrentRound.setBounds(10, 0, 414, 25);
			panelGame.add(lblCurrentRound);
		}
		 
		//G
	static void initializeBetLabel() {
			lblRoundBet.setBounds(143, 241, 95, 14);
		}
		
		 //G
	static void initializeRoundBetLbl() {
			panelGame.add(lblRoundBet);
			textRoundBet = new JTextField();
			textRoundBet.setHorizontalAlignment(SwingConstants.CENTER);
			textRoundBet.setText("10");
			textRoundBet.setBounds(248, 238, 46, 20);
			panelGame.add(textRoundBet);
			textRoundBet.setColumns(10);
		}
		
		//G	
	static void initializeBtnQuit() {
			btnQuit.setBounds(335, 237, 89, 23);
			panelGame.add(btnQuit);
		}
		
		//G
	static void btnQuit() {
			btnQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameInvisible();
					MainMenu.menuVisible();
				}
			});
		}
		 //G
	static void initializeBtnContinue() {
			btnContinue.setBounds(10, 237, 89, 23);
			panelGame.add(btnContinue);
		}
		
		 //G
	static void btnContinue() {
			btnContinue.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					coinOff();
					playerOne.resetScore();
					playerTwo.resetScore();
					game.setCurrentRound(1);
					//btnRoll.setVisible(true);
					MainMenu.refreshGameLabels();
					btnContinue.setVisible(false);	
					System.out.println("Button CONTINUE");
				}
			});
		}
		
		 //G
	static void initializeRollBtn()	{
			btnRoll.setBounds(10, 237, 89, 23);
			panelGame.add(btnRoll);	
				}
			
		//G
	static void btnRoll() {
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
						MainMenu.refreshGameLabels();
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
				panelGame.add(panelCoin);
				ImageIcon coinGif = new ImageIcon(GameMenu.class.getResource("coinflip.gif"));
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

