package ch.rpg.felix.rpg.BattleSystem;

public class Skills {

    private String spellname;
    private int mp_cost;
    private double modifier;
    private int def_pen;
    private int spr_pen;
    private int type;      //0 = magic, 1 = physical, 2 = hybrid

    public Skills(String spellname, double modifier, int def_pen, int spr_pen, int mp_cost, int type) {
        this.spellname = spellname;
        this.modifier = modifier;
        this.def_pen = def_pen;
        this.spr_pen = spr_pen;
        this.mp_cost = mp_cost;
        this.type = type;
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

    public int getDef_pen() {
        return def_pen;
    }

    public int getSpr_pen() {
        return spr_pen;
    }

    public int getType() {
        return type;
    }
}
