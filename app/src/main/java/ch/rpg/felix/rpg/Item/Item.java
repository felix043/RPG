package ch.rpg.felix.rpg.Item;

public class Item {

    private String itemname;
    private int itemdamage;

    public Item(String itemname, int itemdamage) {
        this.itemname = itemname;
        this.itemdamage = itemdamage;
    }

    public String getItemname() {
        return itemname;
    }

    public int getItemdamage() {
        return itemdamage;
    }
}
