package ch.rpg.felix.rpg;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ch.rpg.felix.rpg.Database.ItemViewModel;
import ch.rpg.felix.rpg.Database.OwnedItems.InventoryAdapter;
import ch.rpg.felix.rpg.Database.OwnedItems.ItemsOwnedEntity;

public class InventoryFragment extends Fragment {

    private Intent i;
    private int equipID;
    private ItemViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list_inventory);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final InventoryAdapter adapter = new InventoryAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        viewModel.getallOwnedItems().observe(this, new Observer<List<ItemsOwnedEntity>>() {
            @Override
            public void onChanged(@Nullable List<ItemsOwnedEntity> itemsOwnedEntity) {
                adapter.setOwnedNotes(itemsOwnedEntity);
            }
        });

        return view;
    }
}
