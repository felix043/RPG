package ch.rpg.felix.rpg.BattleSystem;

public class Skills {

    private int damage;
    private String name;

    public void punch(){
        damage = 10;
        name = "Punch";
    }

    public void slash(){
        damage = 15;
        name = "Slash";
    }

}
