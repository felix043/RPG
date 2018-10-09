package ch.rpg.felix.rpg.BattleSystem;

import java.util.Random;

public class Enemies {

    private int enemy_hp;
    private int enemy_atk;
    private int sdf;
    private String enemy_name;

    EnemyRandomizer enemyRandomizer = new EnemyRandomizer();
    Skills skills = new Skills();

    public void Goblin(){
        enemy_name = "Goblin";
        enemy_hp = 10;
        enemy_atk = 5;
    }

    public void Ogre(){
        enemy_name = "Ogre";
        enemy_hp = 20;
        enemy_atk = 25;
    }

    public void Rat(){
        enemy_name = "Rat";
        enemy_hp = 5;
        enemy_atk = 3;
    }

    public int getEnemy_hp() {
        enemyRandomizer.enemies1_1();
        return enemy_hp;
    }
}
