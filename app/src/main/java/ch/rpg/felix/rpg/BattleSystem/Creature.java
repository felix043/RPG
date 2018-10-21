package ch.rpg.felix.rpg.BattleSystem;

import android.support.v7.app.AppCompatActivity;

public class Creature extends AppCompatActivity {

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

    private Skills[] skillArray;

    public Creature(String name, int level, int max_hp, int max_mp, int current_hp, int current_mp, int atk, int mag, int def, int spr, Skills[] skillArray) {
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
        this.skillArray = skillArray;
    }

    public Creature(String name) {
        this(name, 1, 10, 1, 10, 10, 5, 5, 5, 5, new Skills[0]);
    }

    public Creature() {
        this("Enemy", 1, 10, 1, 10, 10, 5, 5, 5, 5, new Skills[0]);
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

    public void setCurrent_hp(int current_hp) {
        this.current_hp = current_hp;
    }

    public void setCurrent_mp(int current_mp) {
        this.current_mp = current_mp;
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

    public Skills[] getSkillArray() {
        return skillArray;
    }
}
