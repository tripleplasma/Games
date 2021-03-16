package Games;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BattleShip {

	boolean setup = true;
	int turn = 0;
	ImageIcon boat = new ImageIcon("C:\\Users\\kungl\\Pictures\\BattleShip\\UBoat.png");
	ImageIcon sub = new ImageIcon("C:\\Users\\kungl\\Pictures\\BattleShip\\Sub.png");
	ImageIcon waveIcon = new ImageIcon("C:\\Users\\kungl\\Pictures\\BattleShip\\wave.png");
	ImageIcon hit = new ImageIcon("C:\\Users\\kungl\\Pictures\\BattleShip\\hit.png");
	JFrame frame = new JFrame();
	JPanel player1 = panelSetup();
	JPanel player2 = panelSetup();
	ArrayList<String> pieces1 = new ArrayList<>();
	ArrayList<String> pieces2 = new ArrayList<>();

	public BattleShip() {

		frame.add(player1);
		frame.setSize(560, 595);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 200);
		frame.setResizable(false);
		frame.setTitle("Select a U-Boat, 2 spaces");
		JOptionPane.showMessageDialog(frame, "Select a U-Boat, 2 spaces", "Set-Up", JOptionPane.PLAIN_MESSAGE);
	}

	public JPanel panelSetup() {
		JPanel panel = new JPanel(new GridLayout(11, 11));
		String[] aplha = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		String[] nums = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		panel.add(new JLabel());
		for (int i = 0; i < 10; i++) {
			JLabel cords = new JLabel();
			cords.setText("       " + aplha[i]);
			panel.add(cords);
		}
		for (int i = 0; i < 100; i++) {
			if (i % 10 == 0) {
				JLabel cords = new JLabel();
				cords.setText("        " + nums[i / 10]);
				panel.add(cords);
			}
			JLabel wave = new JLabel(waveIcon);
			wave.setName(aplha[i % 10] + "" + (i / 10 + 1));
			wave.addMouseListener(clickWave(wave));
			panel.add(wave);

		}
		return panel;
	}

	public void shipSetup(JLabel wave, ArrayList<String> piece) {
		if (wave.getIcon() != waveIcon) {
			JOptionPane.showMessageDialog(frame, "Already has a ship, Try another spot", "Whoops!",
					JOptionPane.PLAIN_MESSAGE);
		} else {
			piece.add(wave.getName());
			wave.setIcon(boat);
			if (piece.size() >= 3)
				wave.setIcon(sub);

			if (piece.size() == 2) {
				frame.setTitle("Select a Sub, 3 spaces");
				JOptionPane.showMessageDialog(frame, "Select a Sub, 3 spaces", "Set-Up", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}

	public MouseListener clickWave(JLabel wave) {
		MouseListener m = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!setup) {
					if(turn%2 == 0) {
						if(pieces2.contains(wave.getName())) {
							JOptionPane.showMessageDialog(frame, "HIT", "WARNING", JOptionPane.PLAIN_MESSAGE);
							wave.setIcon(hit);
							pieces2.remove(wave.getName());
							if(pieces2.size()==0) {
							JOptionPane.showMessageDialog(frame, "Player 1 Wins","Congrats", JOptionPane.PLAIN_MESSAGE);
							String[] arr = {"Yes","No"};
							int choice = JOptionPane.showOptionDialog(frame, "Wanna Play Again?", "Game Finished!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, arr , "No");
							if(choice == 0) {
								frame.dispose();
								new GUI();
							} else if (choice == 1) {
								frame.dispose();
								System.exit(0);
							}
							}
						} else {
							JOptionPane.showMessageDialog(frame, "MISS","LMAO", JOptionPane.PLAIN_MESSAGE);
						}
						turn++;
						frame.remove(player1);
						frame.add(player2);
						frame.repaint();
						frame.validate();
						
					} else if (turn%2 == 1) {
						if(pieces1.contains(wave.getName())) {
							JOptionPane.showMessageDialog(frame, "HIT", "WARNING", JOptionPane.PLAIN_MESSAGE);
							wave.setIcon(hit);
							pieces1.remove(wave.getName());
							if(pieces1.size()==0) {
							JOptionPane.showMessageDialog(frame, "Player 2 Wins","Congrats", JOptionPane.PLAIN_MESSAGE);
							String[] arr = {"Yes","No"};
							int choice = JOptionPane.showOptionDialog(frame, "Wanna Play Again?", "Game Finished!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, arr , "No");
							if(choice == 0) {
								frame.dispose();
								new GUI();
							} else if (choice == 1) {
								frame.dispose();
								System.exit(0);
							}
							}
						} else {
							JOptionPane.showMessageDialog(frame, "MISS","LMAO", JOptionPane.PLAIN_MESSAGE);
						}
						turn++;
						frame.remove(player2);
						frame.add(player1);
						frame.repaint();
						frame.validate();
						
					}
					
				} else if (setup) {
					if (pieces1.size() != 5) {
						shipSetup(wave, pieces1);
						if (pieces1.size() == 5) {
							JOptionPane.showMessageDialog(frame, "Player2's turn", "Set-Up", JOptionPane.PLAIN_MESSAGE);
							frame.remove(player1);
							frame.add(player2);
							frame.validate();
							frame.setTitle("Select a U-Boat, 2 spaces");
							JOptionPane.showMessageDialog(frame, "Select a U-Boat, 2 spaces", "Set-Up",
									JOptionPane.PLAIN_MESSAGE);
						}
					} else if (pieces2.size() != 5) {
						shipSetup(wave, pieces2);
						if (pieces2.size() == 5) {
							JOptionPane.showMessageDialog(frame, "Player1's time to fire", "WAR",
									JOptionPane.PLAIN_MESSAGE);
							frame.remove(player2);
							frame.add(player1);
							frame.validate();
							frame.repaint();
							setup = false;
						}
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		};
		return m;

	}

	public static void main(String[] args) {
		new BattleShip();
	}

}
