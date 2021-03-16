package Games;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLOutput;

public class BlackSpace {

    private int boardIndexRow;
    private int boardIndexCol;
    private int panelIndex;
    private Chip parent;
    private JLabel label;
    private ImageIcon img;
    public static ImageIcon redIcon = new ImageIcon(".\\CheckerBoard\\red.png");
    private BlackSpace self = this;
    private String tag = "BlackSpace";

    public BlackSpace(int index){
        this.panelIndex = index;
        boardIndexRow = index/8;
        boardIndexCol = index%8;
        img = new ImageIcon(".\\CheckerBoard\\black.png");
        label = new JLabel(img);
        setMouseListener();
    }

    public void setMouseListener(){
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(label.getIcon().equals(redIcon)){
                    System.out.println("You click: "+ boardIndexRow+":"+boardIndexCol+" or "+panelIndex );
                    Checkers.updateChipLocation(self,parent);
                }
            }
            @Override public void mousePressed(MouseEvent e) { }@Override public void mouseReleased(MouseEvent e) { }@Override public void mouseEntered(MouseEvent e) { }@Override public void mouseExited(MouseEvent e) { }});
    }

    public int getPanelIndex() {return panelIndex;}
    public void setPanelIndex(int panelIndex) {this.panelIndex = panelIndex; boardIndexRow=panelIndex/8; boardIndexCol=panelIndex%8;}

    public int getBoardIndexRow() {return boardIndexRow;}
    public int getBoardIndexCol() {return boardIndexCol;}
    public void setBoardIndex(int r, int c) {boardIndexRow = r; boardIndexCol =c; panelIndex=r*8+c;}

    public JLabel getLabel() {return label;}
    public void setLabel(JLabel label) {this.label = label;}

    public ImageIcon getImg() {return img;}
    public void setImg(ImageIcon img) {this.img = img;}

    public void setTag(String t){this.tag = t;}

    public void setParent(Chip parent) {this.parent = parent;}

    public String toString(){
        return tag+" is "+img.toString()+"; Panel Index = "+panelIndex+"; BoardIndexRow = "+boardIndexRow+"; BoardIndexCol = "+boardIndexCol;
    }

    public String boardString(){
        return img.toString().charAt(15)+"";
    }

}
