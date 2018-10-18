package ch.rpg.felix.rpg.Item;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "item_table")
public class Item {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "item_id")
    private int id;

    private String item_name;
    private String item_description;
    private int item_basedamage;
    private int item_damagemodifier;

    private int item_category;
    private int item_hpincrement;

    public Item(int item_category, String item_name, String item_description, int item_basedamage, int item_damagemodifier, int item_hpincrement) {
        this.item_category = item_category;
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_basedamage = item_basedamage;
        this.item_damagemodifier = item_damagemodifier;
        this.item_hpincrement = item_hpincrement;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItem_category() {
        return item_category;
    }

    public int getItem_hpincrement() {
        return item_hpincrement;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_description() {
        return item_description;
    }

    public int getItem_basedamage() {
        return item_basedamage;
    }

    public int getItem_damagemodifier() {
        return item_damagemodifier;
    }
}
