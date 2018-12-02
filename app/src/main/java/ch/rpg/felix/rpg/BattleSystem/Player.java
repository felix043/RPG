package ch.rpg.felix.rpg.BattleSystem;

public class Player extends Creature {

    private int expObtained;
    private int expNeeded;

    public Player(String name, int level, int max_hp, int max_mp,
                  int atk, int mag, int def, int spr, Skills[] skillArray, int expObtained) {
        super(name, level, max_hp, max_mp, atk, mag, def, spr, skillArray);

        this.max_hp = 15;
        this.max_mp = 10;
        this.atk = 3;
        this.mag = 3;
        this.def = 2;
        this.spr = 2;

        this.expObtained = expObtained;
        calculateLevel();
    }

    public Player() {
        this.max_hp = 15;
        this.max_mp = 1000;
        this.atk = 3;
        this.mag = 3;
        this.def = 2;
        this.spr = 2;
    }

    public int calculateLevel() {
        while (expObtained > expNeeded) {
            if (level <= 200) {
                expNeeded = (int) Math.pow(Math.sqrt(level) * 3.5, 1.001) + 10;
            } else if (level <= 250) {
                expNeeded = (int) Math.pow(Math.sqrt(level) * 5, 1.003);
            }

            if (expObtained >= expNeeded) {
                level++;
                statGrowth();
                expObtained -= expNeeded;
            }
        }
        return level;
    }

    public int getExpForNextLv() {
        if (level <= 200) {
            expNeeded = (int) Math.pow(level * level * 3.5, 1.001) + 10;
        } else if (level <= 250) {
            expNeeded = (int) Math.pow(level * level * 5, 1.003);
        }
        return expNeeded;
    }

    public void statGrowth() {
        max_hp += 3;
        max_mp += 2;
        atk += 2;
        mag += 2;
        def += 2;
        spr += 2;
    }

    public int[] getAllStats() {
        int[] playerstats = new int[]{level, max_hp, max_mp, atk, mag, def, spr};
        return playerstats;
    }

    public int getExpObtained() {
        return expObtained;
    }

    public void setExpObtained(int expObtained) {
        this.expObtained = expObtained;
    }
}