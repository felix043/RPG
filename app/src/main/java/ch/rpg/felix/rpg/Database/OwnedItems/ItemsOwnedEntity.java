package ch.rpg.felix.rpg.Database.OwnedItems;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "ownedItemsTable")
public class ItemsOwnedEntity {

    @PrimaryKey
    @ColumnInfo(name = "item_id")
    private int idOwned;

    private String itemOwned_name;
    private String itemOwned_description;
    private int itemOwned_basedamage;
    private int itemOwned_damagemodifier;
    private int itemOwned_category;
    private int itemOwned_hpincrement;
    private int itemOwned_costbronze;
    private int itemOwned_costsilver;
    private int itemOwned_costgold;

    public ItemsOwnedEntity(int itemOwned_category, String itemOwned_name, String itemOwned_description, int itemOwned_basedamage, int itemOwned_damagemodifier, int itemOwned_hpincrement, int itemOwned_costbronze, int itemOwned_costsilver, int itemOwned_costgold) {
        this.itemOwned_category = itemOwned_category;
        this.itemOwned_name = itemOwned_name;
        this.itemOwned_description = itemOwned_description;
        this.itemOwned_basedamage = itemOwned_basedamage;
        this.itemOwned_damagemodifier = itemOwned_damagemodifier;
        this.itemOwned_hpincrement = itemOwned_hpincrement;
        this.itemOwned_costbronze = itemOwned_costbronze;
        this.itemOwned_costsilver = itemOwned_costsilver;
        this.itemOwned_costgold = itemOwned_costgold;
    }

    public int getIdOwned() {
        return idOwned;
    }

    public void setIdOwned(int IdOwned) {
        this.idOwned = idOwned;
    }

    public int getItemOwned_category() {
        return itemOwned_category;
    }

    public int getItemOwned_hpincrement() {
        return itemOwned_hpincrement;
    }

    public String getItemOwned_name() {
        return itemOwned_name;
    }

    public String getItemOwned_description() {
        return itemOwned_description;
    }

    public int getItemOwned_basedamage() {
        return itemOwned_basedamage;
    }

    public int getItemOwned_damagemodifier() {
        return itemOwned_damagemodifier;
    }

    public int getItemOwned_costbronze() {
        return itemOwned_costbronze;
    }

    public int getItemOwned_costsilver() {
        return itemOwned_costsilver;
    }

    public int getItemOwned_costgold() {
        return itemOwned_costgold;
    }
}
