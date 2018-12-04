package ch.rpg.felix.rpg.BattleSystem.Data;

import ch.rpg.felix.rpg.BattleSystem.AI;
import ch.rpg.felix.rpg.BattleSystem.Enemy;
import ch.rpg.felix.rpg.BattleSystem.Skills;

public class AllEnemies {

    private AllConditions ac = new AllConditions();
    private AllSkills as = new AllSkills();

    AI goblinAI = new AI(0, 0, 0, 0, 0, 0, false, new AI[]{ac.eHpMore70pc, ac.eHpLess70pc}, 0, -1);
    Enemy goblin = new Enemy(1, "Goblin", 1, 10, 5, 10, 5, 2, 1, 3, 1, new Skills[]{as.basic, as.punch, as.bodycheck}, goblinAI);

    AI chiefGoblinAI = new AI(0, 0, 0, 0, 0, 0, false, new AI[]{ac.eHpMore70pc, ac.eHpLess70pc}, 0, -1);

    private Enemy[] enemies = new Enemy[]{goblin};

    private Enemy[][] enemyComposition = new Enemy[][]{
            {new Enemy(1, 1), new Enemy(2, 2)},      // Level 1-1
            {new Enemy(1, 2)},                                  // Level 1-2
            {new Enemy(1, 3),}                                  // Level 1-3
    };

    public Enemy[][] getEnemyComposition() {
        return enemyComposition;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }
}