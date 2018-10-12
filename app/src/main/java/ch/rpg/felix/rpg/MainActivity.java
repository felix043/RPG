package ch.rpg.felix.rpg;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import ch.rpg.felix.rpg.BattleSystem.BattleActivity;
import ch.rpg.felix.rpg.ShopSystem.ShopActivity;
import ch.rpg.felix.rpg.ShopSystem.ShopBuyFragment;
import ch.rpg.felix.rpg.ShopSystem.ShopSellFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

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
                Intent i = new Intent();
                i.setClass(MainActivity.this, ShopActivity.class);
                startActivity(i);
                break;
            case R.id.settings:
                Toast.makeText(this, "Settings not implemented yet", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
