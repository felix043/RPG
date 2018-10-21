package ch.rpg.felix.rpg.BattleSystem;

import java.util.Random;

public class Enemies {

    private int enemy_level;
    private Random random_enemylevel;
    private String enemy_name;
    private int enemy_expDrop;

    private int enemy_max_hp;
    private int enemy_max_mp;

    private int enemy_current_hp;
    private int enemy_current_mp;

    private int enemy_atk;
    private int enemy_mag;
    private int enemy_def;
    private int enemy_spr;

    public void Rat() {
        enemy_name = "Rat";
        enemy_level = random_enemylevel.nextInt(2 - 1);
        enemy_max_hp = 5 + enemy_level * 2;
        enemy_atk = 1 + enemy_level;
        enemy_mag = 1 + enemy_level;
        enemy_def = 2 + enemy_level;
        enemy_spr = 2 + enemy_level;
        enemy_expDrop = 1000;
    }

    public void Goblin() {
        enemy_name = "Goblin";
        enemy_level = random_enemylevel.nextInt(3 - 1);
        enemy_max_hp = 10 + enemy_level * 2;
        enemy_atk = 3 + enemy_level;
        enemy_mag = 2 + enemy_level;
        enemy_def = 4 + enemy_level;
        enemy_spr = 2 + enemy_level;
        enemy_expDrop = 2000;
    }

    public void Ogre() {
        enemy_name = "Ogre";
        enemy_level = random_enemylevel.nextInt(4 - 2);
        enemy_max_hp = 20 + enemy_level * 3;
        enemy_atk = 5 + enemy_level;
        enemy_mag = 5 + enemy_level;
        enemy_def = 5 + enemy_level;
        enemy_spr = 5 + enemy_level;
        enemy_expDrop = 5000;
    }

    public String getEnemy_name() {
        return enemy_name;
    }

    public int getEnemy_expDrop() {
        return enemy_expDrop;
    }

    public int getEnemy_max_hp() {
        return enemy_max_hp;
    }

    public int getEnemy_max_mp() {
        return enemy_max_mp;
    }

    public int getEnemy_current_hp() {
        return enemy_current_hp;
    }

    public int getEnemy_current_mp() {
        return enemy_current_mp;
    }

    public int getEnemy_atk() {
        return enemy_atk;
    }

    public int getEnemy_mag() {
        return enemy_mag;
    }

    public int getEnemy_def() {
        return enemy_def;
    }

    public int getEnemy_spr() {
        return enemy_spr;
    }
}
