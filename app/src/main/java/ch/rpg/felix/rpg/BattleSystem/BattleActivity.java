package ch.rpg.felix.rpg.BattleSystem;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ch.rpg.felix.rpg.R;

public class BattleActivity extends AppCompatActivity {

    Dialog dialog;
    Player player;
    Enemy enemy;
    Skills skills;

    private int round;

    Skills basic = new Skills("Basic Attack", 0.5, 1, 1, 0, 1);
    Skills punch = new Skills("Punch", 1, 1, 1, 2, 1);
    Skills slash = new Skills("Slash", 1.2, 1, 1, 3, 1);
    Skills stab = new Skills("Stab", 1.3, 1, 1, 4, 1);
    Skills bodycheck = new Skills("Bodycheck", 1.4, 1, 1, 4, 1);

    Skills icelance = new Skills("Icelance", 1.5, 1, 1, 5, 2);
    Skills fireball = new Skills("Fireball", 1.6, 1, 1, 10, 2);
    Skills lightning = new Skills("Lightning Strike", 1.7, 1, 1, 15, 2);

    //Stats: [1, enemyhealth, maxenemyhealth, enemy_atk, enemy_mag, enemy_def, enemy_spr, round]
    AI more50hp = new AI(1, 2, 1, 0.5, true, new AI[0], 2, 0);
    AI more75hp = new AI(1, 2, 1, 0.75, true, new AI[0], 2, 1);

    AI goblinAI = new AI(0, 0, 0, 0, false, new AI[]{more75hp, more50hp}, 0, -1);

    Enemy goblin = new Enemy("Goblin", 1, 10, 5, 10, 5, 2, 1, 3, 1, new Skills[]{basic, punch, bodycheck}, goblinAI);

    private void showBattleresult() {
        int xpForNextLevel;
        int currentXpObtained;

        dialog.setContentView(R.layout.dialog_battleresult);
        Button btn_home = (Button) dialog.findViewById(R.id.btn_home);
        Button btn_nextstage = (Button) dialog.findViewById(R.id.btn_nextstage);
        TextView txt_currentPlayerxp = (TextView) dialog.findViewById(R.id.current_playerxp_dialog);
        TextView txt_xpForNextLevel = (TextView) dialog.findViewById(R.id.xpforlevelup_dialog);
        TextView battleresult = (TextView) dialog.findViewById(R.id.txt_battleresult);
        ProgressBar pb_xpoptainedafterbattle = (ProgressBar) dialog.findViewById(R.id.player_xpoptainedafterbattle);

        xpForNextLevel = player.getExpForNextLv();
        currentXpObtained = player.getExpObtained();
        txt_currentPlayerxp.setText(String.valueOf(currentXpObtained));
        txt_xpForNextLevel.setText(String.valueOf(xpForNextLevel));
        pb_xpoptainedafterbattle.setMax(xpForNextLevel);
        pb_xpoptainedafterbattle.setProgress(currentXpObtained);

        if (enemy.getCurrent_hp() <= 0) {
            battleresult.setText("You won!");
        } else {
            battleresult.setText("You lost!");
        }

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                onBackPressed();
            }
        });
        btn_nextstage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void playerAttack() {
        Button test = (Button) findViewById(R.id.btn_skillone);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int damage;
                damage = enemy.getCurrent_hp() - 5;
            }
        });
    }

    public boolean fight(){
        while (true) {
            if (player.getCurrent_hp() <= 0) {
                break;
            } else {
                playerAttack();
            }

            if (enemy.getCurrent_hp() <= 0) {
                break;
            } else {
                int damagetoplayer = goblin.attack(new int[]{1, goblin.getCurrent_hp(), goblin.getMax_hp(), goblin.getCurrent_mp(), goblin.getMax_mp()});
            }
        }

        if (player.getCurrent_hp() > 0 && enemy.getCurrent_hp() <= 0) {
            showBattleresult();
            return true;
        } else {
            showBattleresult();
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        dialog = new Dialog(this);
    }
}