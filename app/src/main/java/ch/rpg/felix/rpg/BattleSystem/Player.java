package ch.rpg.felix.rpg.BattleSystem;

public class Player {

    private int player_level;
    private int player_max_hp = 30;
    private int player_atk;

    public Player(){
    }

    public int getPlayer_level() {
        return player_level;
    }

    public void setPlayer_level(int player_level) {
        this.player_level = player_level;
    }

    public int getPlayer_max_hp() {
        return player_max_hp;
    }

    public void setPlayer_max_hp(int player_max_hp) {
        this.player_max_hp = player_max_hp;
    }

    public int getPlayer_atk() {
        return player_atk;
    }

    public void setPlayer_atk(int player_atk) {
        this.player_atk = player_atk;
    }
}
