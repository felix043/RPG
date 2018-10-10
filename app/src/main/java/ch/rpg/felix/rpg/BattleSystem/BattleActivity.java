package ch.rpg.felix.rpg.BattleSystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import ch.rpg.felix.rpg.BattleSystem.Enemies;
import ch.rpg.felix.rpg.BattleSystem.Player;
import ch.rpg.felix.rpg.BattleSystem.Skills;
import ch.rpg.felix.rpg.R;
import ch.rpg.felix.rpg.WorldFragmentChildren.PrologueFragment;

public class BattleActivity extends AppCompatActivity {

    Enemies enemies = new Enemies();
    Skills skills = new Skills();
    private int currentHp;

    private void getEnemyStats() {
        ProgressBar enemy_hp = (ProgressBar) findViewById(R.id.enemy_healthBar);
        TextView enemyName = (TextView) findViewById(R.id.enemy_name);
        TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);
        enemyName.setText(enemies.getEnemy_name());
        currentHp = enemies.getEnemy_hp();
        enemyHp.setText(currentHp + " / " + String.valueOf(enemies.getEnemy_hp()));
        enemy_hp.setMax(enemies.getEnemy_hp());
        enemy_hp.setProgress(enemies.getEnemy_hp());
    }

    private void showEnemy() {
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

    //TODO Rewrite class at a later point for more flexibility (e.g different skills)

    private void setSkillnames() {
        final Button btnSkill1 = (Button) findViewById(R.id.btn_skillone);
        final Button btnSkill2 = (Button) findViewById(R.id.btn_skilltwo);

        skills.slash();
        btnSkill1.setText(skills.getName());
        skills.punch();
        btnSkill2.setText(skills.getName());
    }

    private void BtnSkill() {
        final Button btnSkill1 = (Button) findViewById(R.id.btn_skillone);
        final Button btnSkill2 = (Button) findViewById(R.id.btn_skilltwo);

        btnSkill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEnemy();
                skills.slash();
            }
        });

        btnSkill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateEnemy();
                skills.punch();
            }
        });
    }

    private void updateEnemy() {
        final TextView enemyHp = (TextView) findViewById(R.id.enemy_maxHp);
        final ProgressBar enemy_hp = (ProgressBar) findViewById(R.id.enemy_healthBar);
        int test = enemy_hp.getProgress();
        test = test - skills.getDamage();
        enemy_hp.setProgress(test);
        enemyHp.setText(test + " / " + String.valueOf(enemies.getEnemy_hp()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        showEnemy();
        setSkillnames();
        BtnSkill();
    }
}
