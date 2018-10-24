package ch.rpg.felix.rpg.BattleSystem;

public class DamageCalculation {

    private Player player;
    private Enemy enemy;
    private Skills skills;


    protected int calculatePlayerMagicDamage() {
        int magic_dmg;
        magic_dmg = (int) ((Math.sqrt(player.getMag()) / enemy.getSpr()) * skills.getModifier());
        return magic_dmg;
    }

    protected int calculatePlayerPhysicalDamage() {
        int pysical_dmg;
        pysical_dmg = (int) ((Math.sqrt(player.getAtk()) / enemy.getDef()) * skills.getModifier());
        return pysical_dmg;
    }

    protected int calculatePlayerHybridDamage() {
        int pysical_dmg;
        pysical_dmg = (int) (((Math.sqrt(player.getMag()) / enemy.getSpr()) * skills.getModifier() + (Math.sqrt(player.getAtk()) / enemy.getDef()) * skills.getModifier()) / 2);
        return pysical_dmg;
    }

    protected int calculateEnemyMagicDamage() {
        int magic_dmg;
        magic_dmg = (int) ((Math.sqrt(enemy.getMag()) / player.getSpr()) * skills.getModifier());
        return magic_dmg;
    }

    protected int calculateEnemyPhysicalDamage() {
        int pysical_dmg;
        pysical_dmg = (int) ((Math.sqrt(enemy.getAtk()) / player.getDef()) * skills.getModifier());
        return pysical_dmg;
    }

    protected int calculateEnemyHybridDamage() {
        int pysical_dmg;
        pysical_dmg = (int) (((Math.sqrt(player.getMag()) / enemy.getSpr()) * skills.getModifier() + (Math.sqrt(player.getAtk()) / enemy.getDef()) * skills.getModifier()) / 2);
        return pysical_dmg;
    }
}
