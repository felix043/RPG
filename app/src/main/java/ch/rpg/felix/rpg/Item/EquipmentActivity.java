package ch.rpg.felix.rpg.Item;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ch.rpg.felix.rpg.R;

public class EquipmentActivity extends AppCompatActivity {

    private ItemViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipmentlist);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final ItemAdapter adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);


        int equipID = Integer.parseInt(getIntent().getStringExtra("equipID"));
        if (equipID == 1) {
            viewModel.getAllWeapons().observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(@Nullable List<Item> items) {
                    adapter.setNotes(items);
                }
            });
        } else if (equipID == 2) {
            viewModel.getAllOffhands().observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(@Nullable List<Item> items) {
                    adapter.setNotes(items);
                }
            });
        } else if (equipID == 3) {
            viewModel.getAllHelmets().observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(@Nullable List<Item> items) {
                    adapter.setNotes(items);
                }
            });
        } else if (equipID == 4) {
            viewModel.getAllGauntlets().observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(@Nullable List<Item> items) {
                    adapter.setNotes(items);
                }
            });
        } else if (equipID == 5) {
            viewModel.getAllArmors().observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(@Nullable List<Item> items) {
                    adapter.setNotes(items);
                }
            });
        } else if (equipID == 6) {
            viewModel.getAllBoots().observe(this, new Observer<List<Item>>() {
                @Override
                public void onChanged(@Nullable List<Item> items) {
                    adapter.setNotes(items);
                }
            });
        }
    }
}

