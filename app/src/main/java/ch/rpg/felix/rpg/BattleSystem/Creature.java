package ch.rpg.felix.rpg.BattleSystem;

import android.support.v7.app.AppCompatActivity;

public class Creature extends AppCompatActivity {

    protected String name;
    protected int enemy;
    protected int level;

    protected int max_hp;
    protected int max_mp;

    protected int atk;
    protected int mag;
    protected int def;
    protected int spr;

    protected Skills[] skillArray;

    public Creature(String name, int level, int max_hp, int max_mp, int atk, int mag, int def, int spr, Skills[] skillArray) {
        this.name = name;
        this.level = level;
        this.max_hp = max_hp;
        this.max_mp = max_mp;
        this.atk = atk;
        this.mag = mag;
        this.def = def;
        this.spr = spr;
        this.skillArray = skillArray;
    }

    public Creature(int enemy, int level) {
        this.enemy = enemy;
        this.level = level;
    }

    public Creature() {

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

    public int getEnemy() {
        return enemy;
    }

    public Skills[] getSkillArray() {
        return skillArray;
    }
}
