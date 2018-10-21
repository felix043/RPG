package ch.rpg.felix.rpg.Database.AllItems;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

    @Query("SELECT * FROM item_table ORDER BY item_name DESC")
    LiveData<List<Item>> getAllItems();

    @Query("SELECT * FROM item_table ORDER BY item_name DESC")
    LiveData<List<Item>> getAllOwnedItems();

    @Query("SELECT * FROM item_table WHERE item_category in (1) ORDER BY item_name DESC")
    LiveData<List<Item>> getAllWeapons();

    @Query("SELECT * FROM item_table WHERE item_category in (2) ORDER BY item_name DESC")
    LiveData<List<Item>> getAllOffhands();

    @Query("SELECT * FROM item_table WHERE item_category in (3) ORDER BY item_name DESC")
    LiveData<List<Item>> getAllHelmets();

    @Query("SELECT * FROM item_table WHERE item_category in (4) ORDER BY item_name DESC")
    LiveData<List<Item>> getAllGauntlets();

    @Query("SELECT * FROM item_table WHERE item_category in (5) ORDER BY item_name DESC")
    LiveData<List<Item>> getAllArmors();

    @Query("SELECT * FROM item_table WHERE item_category in (6) ORDER BY item_name DESC")
    LiveData<List<Item>> getAllBoots();
}
