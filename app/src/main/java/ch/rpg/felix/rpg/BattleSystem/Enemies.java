package ch.rpg.felix.rpg.BattleSystem;

public class Enemies {

    private int enemy_hp;
    private int enemy_atk;
    private String enemy_name;
    private int enemy_expDrop;

    Skills skills = new Skills();

    public void Goblin(){
        enemy_name = "Goblin";
        enemy_hp = 10;
        enemy_atk = 1000;
        enemy_expDrop = 2000;
    }

    public void Ogre(){
        enemy_name = "Ogre";
        enemy_hp = 20;
        enemy_atk = 25;
        enemy_expDrop = 5000;
    }

    public void Rat(){
        enemy_name = "Rat";
        enemy_hp = 5;
        enemy_atk = 3;
        enemy_expDrop = 1000;
    }


    public int getEnemy_hp() {
        return enemy_hp;
    }

    public int getEnemy_atk() {
        return enemy_atk;
    }

    public String getEnemy_name() {
        return enemy_name;
    }
}
