package Games;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Checkers {

	JFrame frame = new JFrame();
	static JPanel panel = new JPanel(new GridLayout(8,8));
	static BlackSpace[][] board = new BlackSpace[8][8];
	//TODO: Make changes to the board[][] first, then have methods that edit the panel based on the changes to the barod[][]
	static ImageIcon black = new ImageIcon(".\\CheckerBoard\\black.png");
	//These Vars tell the state of the game, used as reference points to do certain actions like when selecting a red spot
	static boolean isBlackTurn = true;
	static boolean canClickRedSpots = false;
	ArrayList<Chip> blackChips;
	ArrayList<Chip> redChips;
	
	public Checkers() {
		boardSetUp();
		panelSetUp();
		frame.add(panel);
		GUI.defaultFrameWork(frame);
	}

	private void boardSetUp(){
		for(int r = 0; r < 8; r++) {
			for(int c = 0 ; c < 8; c++) {
				int index = r*8+c;
				if(r%2==c%2){
					board[r][c] = r<3 ? new Chip(index,"red") : r>4 ? new Chip(index,"black") : new BlackSpace(index);
				}
			}
		}

	}

	private static void panelSetUp(){
		for(BlackSpace[] r : board){
			for(BlackSpace c : r){
				if(c==null) {
					panel.add(new JLabel(new ImageIcon(".\\CheckerBoard\\white.png")));
				} else
					panel.add(c.getLabel());
			}
		}
	}

	public static void updateChipLocation(BlackSpace bs, Chip c){
		System.out.println(bs+"\n"+c);
		int bsPanelIndex = bs.getPanelIndex();
		int cPanelIndex = c.getPanelIndex();
		board[bs.getBoardIndexRow()][bs.getBoardIndexCol()] = c;
		board[c.getBoardIndexRow()][c.getBoardIndexCol()] = bs;
		bs.setPanelIndex(cPanelIndex);
		c.setPanelIndex(bsPanelIndex);
//		c.getLeft().getLabel().setIcon(black);
//		c.getRight().getLabel().setIcon(black);
		System.out.println(c.getLabel());
		panel.remove(bsPanelIndex);
		panel.add(new JLabel(new ImageIcon(".\\CheckerBoard\\redBlack.png")),bsPanelIndex);
		//new JLabel(new ImageIcon(".\\CheckerBoard\\redBlack.png"))
		panel.validate();
	}

	public static void printBoard(){
		for(BlackSpace[] r : board){
			for(BlackSpace c : r){
				System.out.print(c == null ? "W " : c.boardString()+" ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
		new Checkers();
	}
}
