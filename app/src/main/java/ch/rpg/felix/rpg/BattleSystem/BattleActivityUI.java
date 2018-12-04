package ch.rpg.felix.rpg.BattleSystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ch.rpg.felix.rpg.R;

public class BattleActivityUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        loadEnemy();
        loadPlayerEnemyStats();
        showSkills();
        showBattleprogress();
    }
}
