package ch.rpg.felix.rpg.Database.OwnedItems;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ch.rpg.felix.rpg.R;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ItemHolder> {

    private List<ItemsOwnedEntity> itemsOwnedEntity = new ArrayList<>();

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_inventory, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        ItemsOwnedEntity currentItem = itemsOwnedEntity.get(position);
        holder.itemname.setText(currentItem.getItemOwned_name());
        holder.itemdescription.setText("+ " + String.valueOf(currentItem.getItemOwned_basedamage()) + " ATK");
    }

    @Override
    public int getItemCount() {
        return itemsOwnedEntity.size();
    }

    public void setOwnedNotes(List<ItemsOwnedEntity> itemsOwnedEntity) {
        this.itemsOwnedEntity = itemsOwnedEntity;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView itemname;
        private TextView itemdescription;

        public ItemHolder(View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.txt_itemname);
            itemdescription = itemView.findViewById(R.id.txt_details);
        }
    }
}