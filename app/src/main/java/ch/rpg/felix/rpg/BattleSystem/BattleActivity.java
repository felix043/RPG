package ch.rpg.felix.rpg.BattleSystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ch.rpg.felix.rpg.BattleSystem.Enemies;
import ch.rpg.felix.rpg.BattleSystem.Player;
import ch.rpg.felix.rpg.BattleSystem.Skills;
import ch.rpg.felix.rpg.R;

public class BattleActivity extends AppCompatActivity {

    Enemies enemies = new Enemies();
    Player player = new Player();
    Skills skills = new Skills();

    //yet to be implemented
    private int currentHp;

    public void showEnemy() {
        TextView enemyName = (TextView) findViewById(R.id.enemy_name);
        TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);

        enemyName.setText(enemies.getEnemy_name());
        enemyHp.setText(currentHp + " / " + String.valueOf(enemies.getEnemy_hp()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        showEnemy();
    }
}
