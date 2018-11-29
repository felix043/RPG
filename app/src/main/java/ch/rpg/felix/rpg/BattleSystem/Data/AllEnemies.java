package ch.rpg.felix.rpg.BattleSystem.Data;

import ch.rpg.felix.rpg.BattleSystem.AI;
import ch.rpg.felix.rpg.BattleSystem.Enemy;
import ch.rpg.felix.rpg.BattleSystem.Skills;

public class AllEnemies {

    private AllConditions ac = new AllConditions();

    AI goblinAI = new AI(0, 0, 0, 0, false, new AI[]{ac.more75hp, ac.more50hp}, 0, -1);
    private AllSkills as = new AllSkills();
    Enemy goblin = new Enemy("Goblin", 1, 10, 5, 10, 5, 2, 1, 3, 1, new Skills[]{as.basic, as.punch, as.bodycheck}, goblinAI);

    private Enemy[][] enemyComposition = new Enemy[][]{
            {new Enemy(1, 1)},      // Level 1
            {new Enemy(1, 2)},      // Level 2
            {new Enemy(1, 3),}      // Level 3
    };

    public Enemy[][] getEnemyComposition() {
        return enemyComposition;
    }
}