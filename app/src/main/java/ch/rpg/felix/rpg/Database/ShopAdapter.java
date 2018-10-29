package ch.rpg.felix.rpg.Database;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ch.rpg.felix.rpg.R;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ItemHolder> {

    private SQLiteDatabase db;
    private int i;
    private List<Item> item = new ArrayList<>();

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_equipment, parent, false);
        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, final int position) {
        Item currentItem = item.get(position);
        holder.itemname.setText(currentItem.getItem_name());
        holder.itemdescription.setText(currentItem.getItem_description());
        holder.buyitem.setText("Buy");
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public void setNotes(List<Item> itemEntities) {
        this.item = itemEntities;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView itemname;
        private TextView itemdescription;
        private Button buyitem;

        public ItemHolder(View itemView) {
            super(itemView);
            itemname = itemView.findViewById(R.id.txt_itemname);
            itemdescription = itemView.findViewById(R.id.txt_details);
            buyitem = itemView.findViewById(R.id.btn_equip);
        }
    }
}