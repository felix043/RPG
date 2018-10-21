package ch.rpg.felix.rpg.BattleSystem;

import ch.rpg.felix.rpg.Player.LevelAlgorithm;

public class Player extends Creature {

    private LevelAlgorithm levelAlgorithm = new LevelAlgorithm();

    public Player() {
        super("Player");
    }

    public int getPlayer_level() {
        return levelAlgorithm.expNeededForNextLv();
    }

    public int getPlayer_max_hp() {
        return getPlayer_level() * 5;
    }

    public int getPlayer_current_hp() {
        return getCurrent_hp();
    }

    public int getPlayer_current_mp() {
        return getCurrent_mp();
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
