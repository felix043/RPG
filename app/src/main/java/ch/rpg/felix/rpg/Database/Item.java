package ch.rpg.felix.rpg.Database;

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

    private int item_costbronze;
    private int item_costsilver;
    private int item_costgold;


    public Item(int item_category, String item_name, String item_description, int item_basedamage, int item_damagemodifier, int item_hpincrement, int item_costbronze, int item_costsilver, int item_costgold) {
        this.item_category = item_category;
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_basedamage = item_basedamage;
        this.item_damagemodifier = item_damagemodifier;
        this.item_hpincrement = item_hpincrement;
        this.item_costbronze = item_costbronze;
        this.item_costsilver = item_costsilver;
        this.item_costgold = item_costgold;
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

    public int getItem_costbronze() {
        return item_costbronze;
    }

    public int getItem_costsilver() {
        return item_costsilver;
    }

    public int getItem_costgold() {
        return item_costgold;
    }
}
