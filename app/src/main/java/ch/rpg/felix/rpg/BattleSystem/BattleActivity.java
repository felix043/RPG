package ch.rpg.felix.rpg.BattleSystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ch.rpg.felix.rpg.BattleSystem.Enemies;
import ch.rpg.felix.rpg.BattleSystem.Player;
import ch.rpg.felix.rpg.BattleSystem.Skills;
import ch.rpg.felix.rpg.R;
import ch.rpg.felix.rpg.WorldFragmentChildren.PrologueFragment;

public class BattleActivity extends AppCompatActivity {

    Enemies enemies = new Enemies();

    public void getEnemyStats() {
        TextView enemyName = (TextView) findViewById(R.id.enemy_name);
        TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);
        enemyName.setText(enemies.getEnemy_name());
        enemyHp.setText(String.valueOf(enemies.getEnemy_hp()));
    }

    public void showEnemy() {
        int stage1 = Integer.parseInt(getIntent().getStringExtra("stage"));

        if (stage1 == 11) {
            enemies.Rat();
            getEnemyStats();
        } else if (stage1 == 12) {
            enemies.Goblin();
            getEnemyStats();
        } else if (stage1 == 13) {
            enemies.Ogre();
            getEnemyStats();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        showEnemy();
    }
}
