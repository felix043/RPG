package ch.rpg.felix.rpg.BattleSystem;

public class DamageCalculation {

    Player player;
    Enemies enemy;
    Skills skills;

    protected int calculatePlayerMagicDamage() {
        int magic_dmg;
        magic_dmg = (int) ((Math.sqrt(player.getPlayer_mag()) / enemy.getEnemy_spr()) * skills.getModifier() * skills.getBasedamage());
        return magic_dmg;
    }

    protected int calculatePlayerPhysicalDamate() {
        int pysical_dmg;
        pysical_dmg = (int) ((Math.sqrt(player.getPlayer_atk()) / enemy.getEnemy_spr()) * skills.getModifier() * skills.getBasedamage());
        return pysical_dmg;
    }

    protected int calculateEnemyMagicDamage() {
        int magic_dmg;
        magic_dmg = (int) ((Math.sqrt(enemy.getEnemy_mag()) / player.getPlayer_spr()) * skills.getModifier() * skills.getBasedamage());
        return magic_dmg;
    }

    protected int calculateEnemyPhysicalDamate() {
        int pysical_dmg;
        pysical_dmg = (int) ((Math.sqrt(enemy.getEnemy_atk()) / player.getPlayer_spr()) * skills.getModifier() * skills.getBasedamage());
        return pysical_dmg;
    }
}
