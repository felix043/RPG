package ch.rpg.felix.rpg.BattleSystem;

import java.util.Random;

public class Enemies {

    private int enemy_hp;
    private int enemy_atk;
    private String enemy_name;

    Skills skills = new Skills();

    public void Goblin(){
        enemy_name = "Goblin";
        enemy_hp = 10;
        enemy_atk = 1000;
    }

    public void Hobgoblin() {
        enemy_name = "Hobgoblin";
        enemy_hp = 20;
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

    public void enemies1_1() {
        Random random = new Random();
        int numberOfMethods = 3;
        switch (random.nextInt(numberOfMethods)) {
            case 0:
                Goblin();
                break;
            case 1:
                Ogre();
                break;
            case 2:
                Rat();
                break;
        }
    }

    public int getEnemy_hp() {
        enemies1_1();
        return enemy_hp;
    }

    public int getEnemy_atk() {
        return enemy_atk;
    }

    public String getEnemy_name() {
        return enemy_name;
    }
}
