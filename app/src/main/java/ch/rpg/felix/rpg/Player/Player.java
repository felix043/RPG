package ch.rpg.felix.rpg.Player;

import android.support.v7.app.AppCompatActivity;

import ch.rpg.felix.rpg.Player.LevelAlgorithm;

public class Player extends AppCompatActivity {

    LevelAlgorithm levelAlgorithm = new LevelAlgorithm();

    private int player_max_hp;
    private int hp;

    public Player(){
        player_max_hp = 10;
    }

    public int getPlayer_level() {
        return levelAlgorithm.expNeededForNextLv();
    }

    public int getPlayer_max_hp() {
        return getPlayer_level() * 5;
    }

    public int getPlayerCurrentHealth() {
        int max = getPlayer_max_hp();
        if (player_max_hp > max) {
            player_max_hp = max;
        }
        return player_max_hp;
    }

    public float getStrength() {
        return getPlayer_level() * 4f;
    }

    public float getMagic() {
        return getPlayer_level() * 2f;
    }
}
