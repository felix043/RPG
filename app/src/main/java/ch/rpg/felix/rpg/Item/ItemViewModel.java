package ch.rpg.felix.rpg.Item;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {

    private MutableLiveData<List<Item>> item = null;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        item = new MutableLiveData<>();
        item.setValue(ItemRepository.instance().getItem());
    }

    LiveData<List<Item>> getItems() {
        return item;
    }

    public void createCookie(String itemname, int itemdamage) {
        ItemRepository.instance().createItem(itemname, itemdamage);
        item.setValue(ItemRepository.instance().getItem());
    }
}
