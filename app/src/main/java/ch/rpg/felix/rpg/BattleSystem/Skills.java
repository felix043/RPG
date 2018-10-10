package ch.rpg.felix.rpg.BattleSystem;

public class Skills {

    private int damage;
    private String name;

    public void punch(){
        damage = 1;
        name = "Punch";
    }

    public void slash(){
        damage = 2;
        name = "Slash";
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
