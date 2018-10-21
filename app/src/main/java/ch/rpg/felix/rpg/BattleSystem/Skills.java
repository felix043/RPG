package ch.rpg.felix.rpg.BattleSystem;

public class Skills {

    DamageCalculation dc;
    private Player player;
    private Enemies enemy;

    private String spellname;
    private int mp_cost;
    private double modifier;
    private int basedamage;
    private int def_pen;
    private int spr_pen;
    private int final_damage;

    public int usePunch() {
        spellname = "Punch";
        basedamage = 2;
        modifier = 1.3;
        def_pen = 0;
        mp_cost = 3;

        return final_damage;
    }

    public int useSlash() {
        spellname = "Slash";
        basedamage = 4;
        modifier = 1.4;
        def_pen = 10;
        mp_cost = 6;
        return final_damage;
    }

    public int useFireball() {
        spellname = "Fireball";
        basedamage = 10;
        modifier = 1.5;
        spr_pen = 1;
        mp_cost = 10;
        return final_damage;
    }

    public String getSpellname() {
        return spellname;
    }

    public int getMp_cost() {
        return mp_cost;
    }

    public double getModifier() {
        return modifier;
    }

    public int getBasedamage() {
        return basedamage;
    }

    public int getDef_pen() {
        return def_pen;
    }

    public int getSpr_pen() {
        return spr_pen;
    }
}
