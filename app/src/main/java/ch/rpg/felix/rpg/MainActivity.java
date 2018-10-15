package ch.rpg.felix.rpg;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import ch.rpg.felix.rpg.Player.Player;
import ch.rpg.felix.rpg.Player.LevelAlgorithm;
import ch.rpg.felix.rpg.ShopSystem.ShopBuyFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Player player = new Player();
    LevelAlgorithm la = new LevelAlgorithm();

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
        la.expNeededForNextLv();
        showPlayerLevel();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.world:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new WorldFragment()).commit();
                break;
            case R.id.quest:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new QuestFragment()).commit();
                break;
            case R.id.inventory:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new InventoryFragment()).commit();
                break;
            case R.id.character:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CharacterFragment()).commit();
                break;
            case R.id.skilltree:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SkilltreeFragment()).commit();
                break;
            case R.id.shop:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ShopBuyFragment()).commit();
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
        ;
        TextView navPlayername = (TextView) hView.findViewById(R.id.currentPlayerlevel);
        ProgressBar pb = (ProgressBar) hView.findViewById(R.id.player_xpbar);
        navPlayername.setText(String.valueOf(player.getPlayer_level()));
        pb.setMax(la.getExpForNextLv());
        pb.setProgress(la.getExpObtained());
    }
}
