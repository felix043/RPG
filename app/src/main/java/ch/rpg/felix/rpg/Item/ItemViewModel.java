package ch.rpg.felix.rpg.Item;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private LiveData<List<Item>> allItems;
    private ItemRepository repository;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllItems();
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
}
