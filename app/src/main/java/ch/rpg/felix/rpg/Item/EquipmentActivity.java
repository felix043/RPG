package ch.rpg.felix.rpg.Item;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ch.rpg.felix.rpg.R;

public class EquipmentActivity extends AppCompatActivity {

    private ItemViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipmentlist);

        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);


        viewModel.getItems();
        //Setup recycler view
        RecyclerView recyclerView = findViewById(R.id.list_equipment);
        ItemAdapter itemAdapter = new ItemAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(itemAdapter);
    }

}
