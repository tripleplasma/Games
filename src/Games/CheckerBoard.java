package Games;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckerBoard {

	public static void setup(JPanel panel) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0 ; j < 8; j++) {
				// j%2==0 && i%2==0 B, j%2==1 && i%2==0 W,
				// j%2==1 && i%2==1 B, j%2==0 && i%2==1 W,
				panel.add(j%2==i%2 ? new JLabel(new ImageIcon(".\\CheckerBoard\\black.png")) : new JLabel(new ImageIcon(".\\CheckerBoard\\white.png")));
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new GridLayout(8, 8));
		setup(panel);
		frame.add(panel);
		GUI.defaultFrameWork(frame);
	}

}
