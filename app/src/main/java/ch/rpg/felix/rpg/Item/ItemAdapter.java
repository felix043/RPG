package ch.rpg.felix.rpg.Item;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ch.rpg.felix.rpg.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_equipmentlist, parent, false);
        return new ItemViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = ItemRepository.instance().getItem().get(position);
        holder.itemname.setText(item.getItemname());
        holder.itemdamage.setText(item.getItemdamage());
    }

    @Override
    public int getItemCount() {
        return ItemRepository.instance().getItem().size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView itemname;
        private TextView itemdamage;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.txt_itemname);
            itemdamage = itemView.findViewById(R.id.txt_details);
        }
    }
}
