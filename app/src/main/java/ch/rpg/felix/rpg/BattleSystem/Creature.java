package ch.rpg.felix.rpg.BattleSystem;

public class Creature {

    private String name;
    private int level;

    private int max_hp;
    private int max_mp;

    private int current_hp;
    private int current_mp;

    private int atk;
    private int mag;
    private int def;
    private int spr;

    private boolean alive;

    public Creature(String name, int level, int max_hp, int max_mp, int current_hp, int current_mp, int atk, int mag, int def, int spr) {
        this.name = name;
        this.level = level;
        this.max_hp = max_hp;
        this.max_mp = max_mp;
        this.current_hp = current_hp;
        this.current_mp = current_mp;
        this.atk = atk;
        this.mag = mag;
        this.def = def;
        this.spr = spr;

        alive = true;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public int getMax_mp() {
        return max_mp;
    }

    public int getCurrent_hp() {
        return current_hp;
    }

    public int getCurrent_mp() {
        return current_mp;
    }

    public int getAtk() {
        return atk;
    }

    public int getMag() {
        return mag;
    }

    public int getDef() {
        return def;
    }

    public int getSpr() {
        return spr;
    }

    public boolean isAlive() {
        return alive;
    }

    public void castSlash(Creature enemy) {
        enemy.sustainDamage(1);
    }

    public void sustainDamage(int value) {
        if (value > 0) {
            current_hp -= value;
        }
        if (current_hp <= 0) {
            alive = false;
        }
    }
}
