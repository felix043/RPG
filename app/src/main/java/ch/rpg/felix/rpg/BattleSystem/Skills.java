package ch.rpg.felix.rpg.BattleSystem;

public class Skills {

    DamageCalculation dc;
    Player player;
    Enemies enemy;

    private String name;
    private int mp_cost;
    private double modifier;
    private int basedamage;
    private int def_pen;
    private int spr_pen;
    private int final_damage;

    public int usePunch() {
        name = "Punch";
        basedamage = 2;
        modifier = 1.3;
        def_pen = 0;
        mp_cost = 3;
        final_damage = calculatePhysicalDamate();
        return final_damage;
    }

    public int useSlash() {
        name = "Slash";
        basedamage = 4;
        modifier = 1.4;
        def_pen = 10;
        mp_cost = 6;
        final_damage = calculatePhysicalDamate();
        return final_damage;
    }

    public int useFireball() {
        name = "Fireball";
        basedamage = 10;
        modifier = 1.5;
        spr_pen = 1;
        mp_cost = 10;
        final_damage = calculateMagicDamage();
        return final_damage;
    }

    protected int calculateMagicDamage() {
        int magic_dmg;
        magic_dmg = (int) ((player.getMag() / enemy.getSpr()) * modifier * basedamage);
        return magic_dmg;
    }

    protected int calculatePhysicalDamate() {
        int pysical_dmg;
        pysical_dmg = (int) ((player.getAtk() / enemy.getDef()) * modifier * basedamage);
        return pysical_dmg;
    }
}
