package ch.rpg.felix.rpg.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import ch.rpg.felix.rpg.Database.AllItems.Item;
import ch.rpg.felix.rpg.Database.OwnedItems.ItemsOwnedEntity;

public class ItemViewModel extends AndroidViewModel {

    private ItemRepository repository;
    private LiveData<List<Item>> allItems;
    private LiveData<List<Item>> allWeapons;
    private LiveData<List<Item>> allOffhands;
    private LiveData<List<Item>> allHelmets;
    private LiveData<List<Item>> allGauntlets;
    private LiveData<List<Item>> allArmors;
    private LiveData<List<Item>> allBoots;

    private LiveData<List<ItemsOwnedEntity>> allOwnedItems;
    private LiveData<List<ItemsOwnedEntity>> allOwnedWeapons;
    private LiveData<List<ItemsOwnedEntity>> allOwnedOffhands;
    private LiveData<List<ItemsOwnedEntity>> allOwnedHelmets;
    private LiveData<List<ItemsOwnedEntity>> allOwnedGauntlets;
    private LiveData<List<ItemsOwnedEntity>> allOwnedArmors;
    private LiveData<List<ItemsOwnedEntity>> allOwnedBoots;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllItems();
        allWeapons = repository.getAllWeapons();
        allOffhands = repository.getAllOffhands();
        allHelmets = repository.getAllHelmets();
        allGauntlets = repository.getAllGauntlets();
        allArmors = repository.getAllArmors();
        allBoots = repository.getAllBoots();
        allOwnedItems = repository.getAllOwnedItems();

        allOwnedItems = repository.getAllOwnedItems();
        allOwnedWeapons = repository.getAllOwnedWeapons();
        allOwnedOffhands = repository.getAllOwnedOffhands();
        allOwnedHelmets = repository.getAllOwnedHelmets();
        allOwnedGauntlets = repository.getAllOwnedGauntlets();
        allOwnedArmors = repository.getAllOwnedArmors();
        allOwnedBoots = repository.getAllOwnedBoots();
    }

    public void insert(Item item) {
        repository.insert(item);
    }

    public void update(Item item) {
        repository.update(item);
    }

    public void delete(Item item) {
        repository.delete(item);
    }

    public void insertO(ItemsOwnedEntity itemsOwnedEntity) {
        repository.insertO(itemsOwnedEntity);
    }

    public void updateO(ItemsOwnedEntity itemsOwnedEntity) {
        repository.updateO(itemsOwnedEntity);
    }

    public void deleteO(ItemsOwnedEntity itemsOwnedEntity) {
        repository.deleteO(itemsOwnedEntity);
    }



    public LiveData<List<Item>> getAllItems() {
        return allItems;
    }

    public LiveData<List<Item>> getAllWeapons() {
        return allWeapons;
    }

    public LiveData<List<Item>> getAllOffhands() {
        return allOffhands;
    }

    public LiveData<List<Item>> getAllHelmets() {
        return allHelmets;
    }

    public LiveData<List<Item>> getAllGauntlets() {
        return allGauntlets;
    }

    public LiveData<List<Item>> getAllArmors() {
        return allArmors;
    }

    public LiveData<List<Item>> getAllBoots() {
        return allBoots;
    }


    public LiveData<List<ItemsOwnedEntity>> allOwnedItems() {
        return allOwnedItems;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedWeapons() {
        return allOwnedWeapons;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedOffhands() {
        return allOwnedOffhands;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedHelmets() {
        return allOwnedHelmets;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedGauntlets() {
        return allOwnedGauntlets;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedArmors() {
        return allOwnedArmors;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedBoots() {
        return allOwnedBoots;
    }
}
