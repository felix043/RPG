package ch.rpg.felix.rpg.BattleSystem;

import ch.rpg.felix.rpg.Player.LevelAlgorithm;

public class Player extends Stats {

    private LevelAlgorithm levelAlgorithm = new LevelAlgorithm();

    public Player(String name, int level, int max_hp, int max_mp, int current_hp, int current_mp, int atk, int mag, int def, int spr) {
        super(name, level, max_hp, max_mp, current_hp, current_mp, atk, mag, def, spr);
    }

    public int getPlayer_level() {
        return levelAlgorithm.expNeededForNextLv();
    }

    public int getPlayer_max_hp() {
        return getPlayer_level() * 5;
    }


}
