package ch.rpg.felix.rpg.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {

    private static ItemRepository instance = null;
    private List<Item> items;

    public ItemRepository() {
        items = new ArrayList<>();
        loadItem();
    }

    synchronized public static ItemRepository instance() {
        if (instance == null) {
            instance = new ItemRepository();
        }
        return instance;
    }

    public void createItem(String itemname, int itemdamage) {
        Item item = new Item(itemname, itemdamage);
        items.add(item);
    }

    public List<Item> getItem() {
        return items;
    }

    private void loadItem() {
        createItem("Wood Sword", 3);
        createItem("Bronze Sword", 5);
        createItem("Iron Sword", 8);
    }
}
