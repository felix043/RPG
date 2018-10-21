package ch.rpg.felix.rpg.BattleSystem;

import ch.rpg.felix.rpg.Player.LevelAlgorithm;

public class Player {

    private LevelAlgorithm levelAlgorithm = new LevelAlgorithm();

    private int level;

    private int max_hp;
    private int max_mp;

    private int current_hp;
    private int current_mp;

    private int atk;
    private int mag;
    private int def;
    private int spr;


    public int getPlayer_level() {
        return levelAlgorithm.expNeededForNextLv();
    }

    public int getPlayer_max_hp() {
        return getPlayer_level() * 5;
    }

    public int getPlayer_current_hp() {
        return current_hp;
    }

    public int getPlayer_current_mp() {
        return current_mp;
    }

    public int getPlayer_max_mp() {
        return getPlayer_level() * 5;
    }

    public int getPlayer_atk() {
        return getPlayer_level() * 5;
    }

    public int getPlayer_mag() {
        return getPlayer_level() * 5;
    }

    public int getPlayer_def() {
        return getPlayer_level() * 5;
    }

    public int getPlayer_spr() {
        return getPlayer_level() * 5;
    }
}
