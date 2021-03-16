package Games;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Chip extends BlackSpace {

    private String color;
    private boolean isKing = false;
    private ArrayList<BlackSpace> redSpots = new ArrayList<>();
    private Chip self = this;
    private BlackSpace left;
    private BlackSpace right;

    public Chip(int index, String color){
        super(index);
        super.setTag("Chip");
        this.color = color;
        super.setImg(new ImageIcon(".\\CheckerBoard\\"+color+"Black.png"));
        super.getLabel().setIcon(getImg());
        //TODO: color matters on how left and right are
//        left = inBoardBounds() ? Checkers.board[getBoardIndexRow()-1][getBoardIndexCol()-1] : null;
//        right = inBoardBounds() ? Checkers.board[getBoardIndexRow()-1][getBoardIndexCol()+1] : null;
    }

    @Override
    public void setMouseListener(){
        getLabel().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                left = Checkers.board[getBoardIndexRow()-1][getBoardIndexCol()-1];
                right = Checkers.board[getBoardIndexRow()-1][getBoardIndexCol()+1];
                //TODO: Might need to add a One Shot for this if statement because of the loop
                if(Checkers.canClickRedSpots){
                    left.getLabel().setIcon(Checkers.black);
                    right.getLabel().setIcon(Checkers.black);
                    Checkers.canClickRedSpots = false;
                } else {
                    left.setParent(self);
                    right.setParent(self);
                    left.getLabel().setIcon(BlackSpace.redIcon);
                    right.getLabel().setIcon(BlackSpace.redIcon);
                    Checkers.canClickRedSpots = true;
                }
            }
            @Override public void mousePressed(MouseEvent e) { }@Override public void mouseReleased(MouseEvent e) { }@Override public void mouseEntered(MouseEvent e) { }@Override public void mouseExited(MouseEvent e) { }});}

    private void clearRed(){

    }


    public BlackSpace getLeft() {return left;}
    public void setLeft(BlackSpace left) {this.left = left;}

    public BlackSpace getRight() {return right; }
    public void setRight(BlackSpace right) {this.right = right;}

    public boolean isKing() {return isKing;}
    public void setKing(boolean king) {isKing = king;}

    @Override
    public String boardString(){
        return (color.charAt(0)+"").toUpperCase();
    }

    private boolean inBoardBounds(){
        if(getPanelIndex() > 20 && getPanelIndex() < 42) return true;
        return false;
    }

}
