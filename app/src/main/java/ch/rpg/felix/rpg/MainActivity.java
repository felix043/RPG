package ch.rpg.felix.rpg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ch.rpg.felix.rpg.BattleSystem.Player;
import ch.rpg.felix.rpg.BattleSystem.Skills;
import ch.rpg.felix.rpg.ShopSystem.ShopBuyFragment;
import ch.rpg.felix.rpg.Skills.SkilltreeFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Player player = new Player("Player", 1, 10, 10, 10, 10, 2, 2, 4, 4, new Skills[]{}, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WorldFragment()).commit();
            navigationView.setCheckedItem(R.id.world);
        }
        showPlayerLevel();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.world:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WorldFragment()).addToBackStack(null).commit();
                break;
            case R.id.quest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new QuestFragment()).addToBackStack(null).commit();
                break;
            case R.id.inventory:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InventoryFragment()).addToBackStack(null).commit();
                break;
            case R.id.character:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CharacterFragment()).addToBackStack(null).commit();
                break;
            case R.id.skilltree:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SkilltreeFragment()).addToBackStack(null).commit();
                break;
            case R.id.shop:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopBuyFragment()).addToBackStack(null).commit();
                break;
            case R.id.settings:
                Toast.makeText(this, "Settings not implemented yet", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showPlayerLevel() {
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navView.getHeaderView(0);
        TextView playerlevel = (TextView) hView.findViewById(R.id.currentPlayerlevel);
        TextView current_playerxp = (TextView) hView.findViewById(R.id.current_playerxp);
        TextView xpforlevelup = (TextView) hView.findViewById(R.id.xpforlevelup);
        ProgressBar pb = (ProgressBar) hView.findViewById(R.id.player_xpbar);

        playerlevel.setText(String.valueOf(player.calculateLevel()));
        current_playerxp.setText(String.valueOf(player.getExpObtained()));
        xpforlevelup.setText(String.valueOf(player.getExpForNextLv()));
        pb.setMax(player.getExpForNextLv());
        pb.setProgress(player.getExpObtained());
    }


}
