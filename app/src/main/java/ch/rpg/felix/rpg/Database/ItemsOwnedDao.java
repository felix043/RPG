package ch.rpg.felix.rpg.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ItemsOwnedDao {

    @Insert
    void insertO(ItemsOwnedEntity itemsOwnedEntity);

    @Update
    void updateO(ItemsOwnedEntity itemsOwnedEntity);

    @Delete
    void deleteO(ItemsOwnedEntity itemsOwnedEntity);

    /*
    @Query("INSERT INTO item_table SELECT item_id FROM ownedItemsTable")
    void transferO(ItemsOwnedEntity itemsOwnedEntity);*/

    @Query("SELECT * FROM ownedItemsTable ORDER BY itemOwned_name DESC")
    LiveData<List<ItemsOwnedEntity>> getAllOwnedItems();

    @Query("SELECT * FROM ownedItemsTable WHERE itemOwned_category in (1) ORDER BY itemOwned_name DESC")
    LiveData<List<ItemsOwnedEntity>> getAllOwnedWeapons();

    @Query("SELECT * FROM ownedItemsTable WHERE itemOwned_category in (2) ORDER BY itemOwned_name DESC")
    LiveData<List<ItemsOwnedEntity>> getAllOwnedOffhands();

    @Query("SELECT * FROM ownedItemsTable WHERE itemOwned_category in (3) ORDER BY itemOwned_name DESC")
    LiveData<List<ItemsOwnedEntity>> getAllOwnedHelmets();

    @Query("SELECT * FROM ownedItemsTable WHERE itemOwned_category in (4) ORDER BY itemOwned_name DESC")
    LiveData<List<ItemsOwnedEntity>> getAllOwnedGauntlets();

    @Query("SELECT * FROM ownedItemsTable WHERE itemOwned_category in (5) ORDER BY itemOwned_name DESC")
    LiveData<List<ItemsOwnedEntity>> getAllOwnedArmors();

    @Query("SELECT * FROM ownedItemsTable WHERE itemOwned_category in (6) ORDER BY itemOwned_name DESC")
    LiveData<List<ItemsOwnedEntity>> getAllOwnedBoots();
}
