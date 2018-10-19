package ch.rpg.felix.rpg.ShopSystem;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
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

import ch.rpg.felix.rpg.Database.Item;
import ch.rpg.felix.rpg.Database.ItemViewModel;
import ch.rpg.felix.rpg.Database.ShopAdapter;
import ch.rpg.felix.rpg.R;

public class ShopBuyFragment extends Fragment {

    protected int bronzecoin;
    protected int silvercoin;
    protected int goldcoin;

    private ItemViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_buy, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list_shop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final ShopAdapter adapter = new ShopAdapter();
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        viewModel.getAllItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                adapter.setNotes(items);
            }
        });

        return view;
    }
}