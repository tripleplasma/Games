package XangGames;

import javax.swing.*;

public class Monster {

    private int gold = 1;
    private int dmg;
    private String attack;
    private JLabel monPic;
    public static final JLabel NONE_MON_PIC = new JLabel(new ImageIcon(".\\DungeonDivers\\none.png"));
    private boolean dead = false;

    public Monster(int dmg, int imageIndex){
        this.dmg = dmg;
        attack = DungeonDivers.ATTACKS[(int)(Math.random()*3)];
        this.monPic = new JLabel(new ImageIcon(".\\DungeonDivers\\"+dmg+imageIndex+".png"));
    }

    public int setDead(){dead = true;return getGold();}
    public boolean isDead(){return dead;}

    public void incrementAttack(int a){dmg+=a;}

    public int getGold(){return gold;}
    public String getAttack(){return attack;}
    public int getDmg(){return dmg;}

    public JLabel getMonPic(){return this.monPic;}
//    public void setTag(String s){tag=s;}
//    public String getTag(){return tag;}
//
//    public void setAttack(String s){attack=s;}

    public String toString(){
        return "Dmg: "+dmg+", Gold: "+gold+", Att: "+ attack;
    }

}
