package Games;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class TestGameThings {

	public TestGameThings(){
		JFrame f = new JFrame();
		JButton b = new JButton("Butotn");
		f.add(b);
		f.setVisible(true);
		f.setSize(300,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(300,300);
	}

	public static void main(String[] args) {
		new TestGameThings();
	}
}

