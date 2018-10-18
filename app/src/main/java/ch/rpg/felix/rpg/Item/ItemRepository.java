package ch.rpg.felix.rpg.Item;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ItemRepository {

    private ItemDao itemDao;
    private LiveData<List<Item>> allItems;
    private LiveData<List<Item>> allWeapons;
    private LiveData<List<Item>> allOffhands;
    private LiveData<List<Item>> allHelmets;
    private LiveData<List<Item>> allGauntlet;
    private LiveData<List<Item>> allArmors;
    private LiveData<List<Item>> allBoots;

    public ItemRepository(Application application) {
        ItemDatabase db = ItemDatabase.getInstance(application);
        itemDao = db.itemDao();
        allItems = itemDao.getAllItems();
        allWeapons = itemDao.getAllWeapons();
        allOffhands = itemDao.getAllOffhands();
        allHelmets = itemDao.getAllHelmets();
        allGauntlet = itemDao.getAllGauntlets();
        allArmors = itemDao.getAllArmors();
        allBoots = itemDao.getAllBoots();
    }

    public void insert(Item item) {
        new InsertItemAsyncTask(itemDao).execute(item);
    }

    public void update(Item item) {
        new UpdateItemAsyncTask(itemDao).execute(item);
    }

    public void delete(Item item) {
        new DeleteItemAsyncTask(itemDao).execute(item);
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
        return allGauntlet;
    }

    public LiveData<List<Item>> getAllArmors() {
        return allArmors;
    }

    public LiveData<List<Item>> getAllBoots() {
        return allBoots;
    }

    private static class InsertItemAsyncTask extends AsyncTask<Item, Void, Void> {

        private ItemDao itemDao;

        private InsertItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.insert(items[0]);
            return null;
        }
    }

    private static class UpdateItemAsyncTask extends AsyncTask<Item, Void, Void> {

        private ItemDao itemDao;

        private UpdateItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.update(items[0]);
            return null;
        }
    }

    private static class DeleteItemAsyncTask extends AsyncTask<Item, Void, Void> {

        private ItemDao itemDao;

        private DeleteItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.delete(items[0]);
            return null;
        }
    }
}
