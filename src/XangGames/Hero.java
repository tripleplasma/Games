package XangGames;

import javax.swing.*;

public abstract class Hero {

    private int hp = 6;
    private Monster monster = null;
    private String attack = null;
    private boolean hasAbility = true;
    private final String tag;

    private JPanel panel = new JPanel();
    private JLabel monPic;
    private JLabel monInfo;
    private final JLabel playerPic;
    private JLabel playerInfo;

    public static final int WON_FIGHT = 0;
    public static final int LOST_FIGHT = 1;
    public static final int DRAW = 2;

    public Hero(String tag){
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        this.tag = tag;
        this.monPic = monster == null ? Monster.NONE_MON_PIC : monster.getMonPic();
        this.monInfo = new JLabel(monsterInfo());
        this.playerPic = new JLabel(new ImageIcon(".\\DungeonDivers\\"+tag+".png"));
        this.playerInfo = new JLabel(playerInfo());

        panel.add(monInfo);
        panel.add(monPic);

        panel.add(playerPic);
        panel.add(playerInfo);
    }

    public int wonFight(){
        if( (monster.getAttack().equals(DungeonDivers.ATTACKS[0]) && attack.equals(DungeonDivers.ATTACKS[1]))
            || (monster.getAttack().equals(DungeonDivers.ATTACKS[1]) && attack.equals(DungeonDivers.ATTACKS[2]))
            || (monster.getAttack().equals(DungeonDivers.ATTACKS[2]) && attack.equals(DungeonDivers.ATTACKS[0]))
            || (monster.isDead())){
            return 0;
        } else if (monster.getAttack().equals(attack)) {
            return 2;
        }
        return 1;
    }

    public abstract void activateAbility();
    public void usedAbility(){hasAbility=false;this.refreshPlayerLabel();}
    public void refreshAbility(){hasAbility=true;this.refreshPlayerLabel();}
    public boolean hasAbility(){return hasAbility;}

    public String getAttack(){return attack;}
    public void setAttack(String choice){this.attack=choice;this.refreshPlayerLabel();}

    public Monster getMonster(){return monster;}
    public void setMonster(Monster newMonster){this.monster = newMonster;this.refreshMonLabel();}
    public void showMonAtt(){this.monInfo.setText(monsterInfo());}
    public void incrementMonAtt(int att){
        if(this.getMonster()!=null) {
            this.getMonster().incrementAttack(att);
        }
        this.refreshMonLabel();
    }

    public int getHp(){return this.hp;}
    public boolean isDead(){return this.hp<=0;}
    public void takeDamage(int loss){ this.hp-=loss;this.refreshPlayerLabel();}
    public void setHp(int heal){this.hp=heal;this.refreshPlayerLabel();}

    public String getTag(){return this.tag;}

    public JPanel getPanel(){ return this.panel; }
    public void setPanel(JPanel p ){this.panel = p; }

    private void refreshPlayerLabel(){ this.playerInfo.setText(playerInfo());}
    private void refreshMonLabel(){
        this.monInfo.setText(monsterInfo().substring(0,monsterInfo().length()-6));
        this.monPic.setIcon(monster == null ? Monster.NONE_MON_PIC.getIcon() : monster.getMonPic().getIcon());
        /*monPic.setIcon(new ImageIcon(monsterInfo().split(":")[0]));*/
    }

    private String playerInfo(){
        if(attack==null) this.attack = "None";
        if(hp<=0) return this.tag+": DEAD";
        return this.tag+": "+this.hp+" Hp, Abil: "+(""+this.hasAbility).toUpperCase()+", Att: "+this.attack;
    }

    private String monsterInfo(){
        return monster == null ? "Monster : None" : this.monster.toString();
    }

    public String showAllInfo(){
        return this.playerInfo()+", "+this.monsterInfo();
    }

    public String toString(){
        return monster!=null ? this.showAllInfo().substring(0,showAllInfo().length()-10) : this.showAllInfo();
    }
}
