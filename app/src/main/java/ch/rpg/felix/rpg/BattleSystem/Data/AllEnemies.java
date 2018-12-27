package ch.rpg.felix.rpg.BattleSystem.Data;

import ch.rpg.felix.rpg.BattleSystem.AI;
import ch.rpg.felix.rpg.BattleSystem.Enemy;
import ch.rpg.felix.rpg.BattleSystem.Skills;

public class AllEnemies {

    private AllConditions ac = new AllConditions();
    private AllSkills as = new AllSkills();

    AI goblinAI = new AI(0, 0, 0, 0, 0, 0, false, new AI[]{ac.goblinMore50, ac.goblinLess50}, 0, -1);
    Enemy goblin = new Enemy(1, "Goblin", 1, 10, 15, 5, 1, 3, 3, new Skills[]{as.basic, as.slash, as.punch}, goblinAI);

    AI spiderAI = new AI(0, 0, 0, 0, 0, 0, false, new AI[]{ac.spiderMore60, ac.spiderLess60}, 0, -1);
    Enemy spider = new Enemy(2, "Spider", 1, 8, 14, 12, 10, 2, 1, new Skills[]{as.basic, as.scratch, as.poisonfang}, spiderAI);

    AI chiefGoblinAI = new AI(0, 0, 0, 0, 0, 0, false, new AI[]{ac.eHpMore70pc, ac.eHpLess70pc}, 0, -1);
    Enemy goblinChief = new Enemy(2, "Goblin Chief", 15, 10, 100, 20, 10, 30, 10, new Skills[]{as.basic, as.punch, as.bodycheck}, chiefGoblinAI);

    AI phantomspiderAI = new AI(0, 0, 0, 0, 0, 0, false, new AI[]{ac.phantomSpiderMore20, ac.phantomSpiderLess20}, 0, -1);
    Enemy phantomSpider = new Enemy(1000, "Phantom Spider", 1, 670, 100, 135, 160, 70, 70, new Skills[]{as.basic, as.lifesplitter, as.depression, as.phantomsting, as.venomspit}, phantomspiderAI);

    AI mummieAI = new AI(0, 0, 0, 0, 0, 0, false, new AI[]{ac.mumieloop1, ac.mumieloop2, ac.mumieloop3, ac.mumieloop4}, 0, -1);
    Enemy mumie = new Enemy(1001, "Mumie", 1, 200000, 5000, 75, 1, 70, 75, new Skills[]{as.basic, as.swipe, as.oblivion, as.painfulscream}, mummieAI);


    private Enemy[] enemies = new Enemy[]{goblin, spider, phantomSpider, mumie};

    private Enemy[][][] enemyComposition = new Enemy[][][]{
            //World Enemies
            {
                    {new Enemy(1, 1), new Enemy(2, 2)},
                    {new Enemy(2, 2)},
                    {new Enemy(1, 3)},
                    {new Enemy(2, 4)},
                    {new Enemy(1, 5)},
                    {new Enemy(2, 6)},
                    {new Enemy(1, 7)},
                    {new Enemy(2, 8)},
                    {new Enemy(1, 9)},
                    {new Enemy(2, 10)},
                    {new Enemy(1, 10)},
            },

            //Boss
            {
                    {new Enemy(1000, 1)},
                    {new Enemy(1001, 1)},
                    {new Enemy(1000, 1)}
            }

    };

    public Enemy[][][] getEnemyComposition() {
        return enemyComposition;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }
}