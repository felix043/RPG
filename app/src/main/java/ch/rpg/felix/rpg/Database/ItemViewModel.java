package ch.rpg.felix.rpg.Database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private LiveData<List<Item>> allItems;
    private LiveData<List<Item>> allWeapons;
    private LiveData<List<Item>> allOffhands;
    private LiveData<List<Item>> allHelmets;
    private LiveData<List<Item>> allGauntlets;
    private LiveData<List<Item>> allArmors;
    private LiveData<List<Item>> allBoots;
    private ItemRepository repository;

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
}
