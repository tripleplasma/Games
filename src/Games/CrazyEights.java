package Games;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CrazyEights {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel(new BorderLayout());
    Deck d = changeNumbers(new Deck(true));
    Player p1 = new Player(new Hand(1,d));
    Player p2 = new Player(new Hand(1,d));
    Player p3 = new Player(new Hand(1,d));
    Player p4 = new Player(new Hand(1,d));
    Player[] players = {p1,p2,p3,p4};
    Player pilePanel;

    public CrazyEights(){
        for(Player p : players){
            System.out.println(p.hand.get(0).symbolNum);
        }
//        panel.add(p1.display,BorderLayout.PAGE_END);
//        panel.add(p2.display,BorderLayout.LINE_START);
//        panel.add(p3.display,BorderLayout.PAGE_START);
//        panel.add(p4.display,BorderLayout.LINE_END);
//        panel.add(pilePanel.display,BorderLayout.CENTER);
//        frame.add(panel);
//        GUI.defaultFrameWork(frame,400,420);
    }

    public MouseListener onClick(){

        return null;
    }

    public Deck changeNumbers(Deck d){
        int[] cardValues = {1,2,3,4,5,6,7,50,9,10,10,10,10};
        HashMap<String,Integer> ret = new HashMap<>();
        for(int i = 0; i < Card.SYMBOLS.length; i++){
            ret.put(Card.SYMBOLS[i],cardValues[i]);
        }
        Card.SYMBOL_TO_NUMBER = ret;
        for(Card c : d.getContents()){
            c.symbolNum = Card.SYMBOL_TO_NUMBER.get(c.symbol);
        }
        return d;
    }

    public static void main(String[] args){
        new CrazyEights();
    }
}
