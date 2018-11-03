package diceGame;

import java.awt.FlowLayout;
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
	private JPanel panelGame;
	private JPanel panelCoin = new JPanel();
	private JPanel panelDicePlayerOne = new JPanel();
	private JPanel panelDicePlayerTwo = new JPanel();
	private JButton btnRoll = new JButton("Roll");
	private JButton btnQuit = new JButton("Quit");
	private JButton btnContinue = new JButton("Continue");
	private JLabel lblCurrentRound = new JLabel();
	private JLabel lblDraw = new JLabel("Draw! Flipping a coin!");
	private JLabel lblRoundBet = new JLabel("Round Bet:");
	private JTextField textRoundBet;
	
	public GameMenu() {
		panelGame  = new JPanel();
		this.initializeAllGame();
	}
	
	public void initializeAllGame() {
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
		initializeDice();
		btnRoll();
		btnQuit();
		btnContinue();
		
	}

	public void gameVisible(boolean value) {
			panelGame.setVisible(value);
		}
			 
	public void initializeGameMenu() {
			panelGame.setBounds(0, 0, 434, 271);
			frame.getContentPane().add(panelGame);
			panelGame.setLayout(null);
			gameVisible(false);
			}
		  
	public void initializeNameLabels() {		
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
		 
	public void initializeFundLabels() {		
			lblFundsPlayerOne = new JLabel("");
			lblFundsPlayerOne.setBounds(10, 52, 46, 14);
			panelGame.add(lblFundsPlayerOne);
			
			lblFundsPlayerTwo = new JLabel("");
			lblFundsPlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblFundsPlayerTwo.setBounds(378, 52, 46, 14);
			panelGame.add(lblFundsPlayerTwo);
		}
			
		 
	public void initializeScoreLabels() {
			lblScorePlayerOne = new JLabel("0");
			lblScorePlayerOne.setBounds(10, 77, 46, 14);
			panelGame.add(lblScorePlayerOne);
			
			lblScorePlayerTwo = new JLabel("0");
			lblScorePlayerTwo.setHorizontalAlignment(SwingConstants.RIGHT);
			lblScorePlayerTwo.setBounds(378, 77, 36, 14);
			panelGame.add(lblScorePlayerTwo);
		}
		 
		 
	public void initializeCurrentRoundLbl() {
			
			lblCurrentRound.setHorizontalAlignment(SwingConstants.CENTER);
			lblCurrentRound.setBounds(10, 0, 414, 25);
			panelGame.add(lblCurrentRound);
		}
		 
		 
	public void initializeBetLabel() {
			lblRoundBet.setBounds(143, 241, 95, 14);
		}
		
		  
	public void initializeRoundBetLbl() {
			panelGame.add(lblRoundBet);
			textRoundBet = new JTextField();
			textRoundBet.setHorizontalAlignment(SwingConstants.CENTER);
			textRoundBet.setText("10");
			textRoundBet.setBounds(248, 238, 46, 20);
			panelGame.add(textRoundBet);
			textRoundBet.setColumns(10);
		}
		
		 	
	public void initializeBtnQuit() {
			btnQuit.setBounds(335, 237, 89, 23);
			panelGame.add(btnQuit);
		}
		
	public void btnQuit() {
			btnQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					gameVisible(false);
					WindowGUI.mainMenu.menuVisible(true);
				}
			});
		}
		  
	public void initializeBtnContinue() {
			btnContinue.setBounds(10, 237, 89, 23);
			panelGame.add(btnContinue);
		}
		
	public void btnContinue() {
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
		
	public void initializeRollBtn()	{
			btnRoll.setBounds(10, 237, 89, 23);
			panelGame.add(btnRoll);	
				}
			
	public void btnRoll() {
			btnRoll.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(playerOne.checkPlayerFunds() && playerTwo.checkPlayerFunds()) {
						coinOff();
						if (game.getRounds()==game.getRound()){
							game.newRound();
							lblCurrentRound.setText("Game Over! " + game.getBetWinner(Integer.parseInt(textRoundBet.getText())).getName() + " wins!");
							btnContinue.setVisible(true);
							renderDice();
							System.out.println("Button ELSE");
							playerOne.clearRoundScore();
							playerTwo.clearRoundScore();
						}
						else if(game.newRound()){
							System.out.println("Button IF");
							lblCurrentRound.setText("Round " + (game.getRound()-1));
							renderDice();
							playerOne.clearRoundScore();
							playerTwo.clearRoundScore();
						}
						refreshGameLabels();
					}
					else {
						btnRoll.setVisible(false);
						btnContinue.setVisible(false);
						playerOne.clearRoundScore();
						playerTwo.clearRoundScore();
					}
				}
			});
		}

			//C
			 public void coinImage() {
				lblDraw();
				panelCoin.setBounds(157, 53, 135, 129);
				panelGame.add(panelCoin);
				ImageIcon coinGif = new ImageIcon(GameMenu.class.getResource("coinflip.gif"));
				JLabel coinLabel = new JLabel(coinGif);
				panelCoin.add(coinLabel);
				panelCoin.setVisible(true);
				coinLabel.setVisible(true);
			}
			 
			 //C			
			 public void lblDraw() {
				panelGame.add(lblDraw);
				lblDraw.setHorizontalAlignment(SwingConstants.CENTER);
				lblDraw.setBounds(10, 0, 414, 25);
				lblCurrentRound.setVisible(false);
				lblDraw.setVisible(true);
			}
			
			 //C 
			public void coinOff() {
				panelCoin.setVisible(false);	
				lblDraw.setVisible(false);
				lblCurrentRound.setVisible(true);
			}
			public void initializeDice() {
				panelDicePlayerOne.setBounds(50, 100, 120, 75);
				panelDicePlayerOne.setLayout(new FlowLayout());
				
				panelDicePlayerTwo.setBounds(265, 100, 120, 75);
				panelDicePlayerTwo.setLayout(new FlowLayout());				
			}
			
			public void renderDice() {
				ImageIcon diceRoll1 = new ImageIcon(GameMenu.class.getResource("diceRoll_1.png"));
				ImageIcon diceRoll2 = new ImageIcon(GameMenu.class.getResource("diceRoll_2.png"));
				ImageIcon diceRoll3 = new ImageIcon(GameMenu.class.getResource("diceRoll_3.png"));
				ImageIcon diceRoll4 = new ImageIcon(GameMenu.class.getResource("diceRoll_4.png"));
				ImageIcon diceRoll5 = new ImageIcon(GameMenu.class.getResource("diceRoll_5.png"));
				ImageIcon diceRoll6 = new ImageIcon(GameMenu.class.getResource("diceRoll_6.png"));
												
				panelDicePlayerOne.removeAll();
				panelDicePlayerTwo.removeAll();
				
				for(int i = 0; i < playerOne.thisRoundRolls.size(); i++) {
					int rollP1 = playerOne.thisRoundRolls.get(i);
					switch (rollP1) {
						case 1: JLabel roll1 = new JLabel(diceRoll1);
								panelDicePlayerOne.add(roll1);
								roll1.setVisible(true);
								break;
						case 2: JLabel roll2 = new JLabel(diceRoll2);
								panelDicePlayerOne.add(roll2);
								roll2.setVisible(true);
								break;
						case 3: JLabel roll3 = new JLabel(diceRoll3);
								panelDicePlayerOne.add(roll3);
								roll3.setVisible(true);
								break;
						case 4: JLabel roll4 = new JLabel(diceRoll4);
								panelDicePlayerOne.add(roll4);
								roll4.setVisible(true);
								break;
						case 5: JLabel roll5 = new JLabel(diceRoll5);
								panelDicePlayerOne.add(roll5);
								roll5.setVisible(true);
								break;
						case 6: JLabel roll6 = new JLabel(diceRoll6);
								panelDicePlayerOne.add(roll6);
								roll6.setVisible(true);
								break;							
					}
				}
				
				for(int i = 0; i < playerTwo.thisRoundRolls.size(); i++) {
					int rollP2 = playerTwo.thisRoundRolls.get(i);
					switch (rollP2) {
						case 1: JLabel roll1 = new JLabel(diceRoll1);
								panelDicePlayerTwo.add(roll1);
								roll1.setVisible(true);
								break;
						case 2: JLabel roll2 = new JLabel(diceRoll2);
								panelDicePlayerTwo.add(roll2);
								roll2.setVisible(true);
								break;
						case 3: JLabel roll3 = new JLabel(diceRoll3);
								panelDicePlayerTwo.add(roll3);
								roll3.setVisible(true);
								break;
						case 4: JLabel roll4 = new JLabel(diceRoll4);
								panelDicePlayerTwo.add(roll4);
								roll4.setVisible(true);
								break;
						case 5: JLabel roll5 = new JLabel(diceRoll5);
								panelDicePlayerTwo.add(roll5);
								roll5.setVisible(true);
								break;
						case 6: JLabel roll6 = new JLabel(diceRoll6);
								panelDicePlayerTwo.add(roll6);
								roll6.setVisible(true);
								break;							
					}
				}
				
				panelGame.add(panelDicePlayerOne);
				panelDicePlayerOne.setVisible(true);	
				
				panelGame.add(panelDicePlayerTwo);
				panelDicePlayerTwo.setVisible(true);
		}
			
	public void rollButtonSetVisible(boolean value) {
		this.btnRoll.setVisible(value);
	}
	
	public void refreshGameLabels() {
		lblNamePlayerOne.setText(playerOne.getName());
		lblNamePlayerTwo.setText(playerTwo.getName());
		lblFundsPlayerOne.setText("$"+playerOne.getMoney());
		lblFundsPlayerTwo.setText("$"+playerTwo.getMoney());
		lblScorePlayerOne.setText(""+playerOne.getScore());
		lblScorePlayerTwo.setText(""+playerTwo.getScore());
	}

}

