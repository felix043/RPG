package ch.rpg.felix.rpg.Database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import ch.rpg.felix.rpg.Database.AllItems.Item;
import ch.rpg.felix.rpg.Database.AllItems.ItemDao;
import ch.rpg.felix.rpg.Database.OwnedItems.ItemsOwnedDao;
import ch.rpg.felix.rpg.Database.OwnedItems.ItemsOwnedEntity;

public class ItemRepository {

    //Items which player owns
    private ItemsOwnedDao itemsOwnedDao;
    private LiveData<List<ItemsOwnedEntity>> allOwnedItems;
    private LiveData<List<ItemsOwnedEntity>> allOwnedWeapons;
    private LiveData<List<ItemsOwnedEntity>> allOwnedOffhands;
    private LiveData<List<ItemsOwnedEntity>> allOwnedHelmets;
    private LiveData<List<ItemsOwnedEntity>> allOwnedGauntlet;
    private LiveData<List<ItemsOwnedEntity>> allOwnedArmors;
    private LiveData<List<ItemsOwnedEntity>> allOwnedBoots;

    //All Items ingame
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

        itemsOwnedDao = db.itemsOwnedDao();
        allOwnedItems = itemsOwnedDao.getAllOwnedItems();
        allOwnedWeapons = itemsOwnedDao.getAllOwnedWeapons();
        allOwnedOffhands = itemsOwnedDao.getAllOwnedOffhands();
        allOwnedHelmets = itemsOwnedDao.getAllOwnedHelmets();
        allOwnedGauntlet = itemsOwnedDao.getAllOwnedGauntlets();
        allOwnedArmors = itemsOwnedDao.getAllOwnedArmors();
        allOwnedBoots = itemsOwnedDao.getAllOwnedBoots();

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

    public void insertO(ItemsOwnedEntity itemsOwnedEntity) {
        new InsertOwnedItemAsyncTask(itemsOwnedDao).execute(itemsOwnedEntity);
    }

    public void updateO(ItemsOwnedEntity itemsOwnedEntity) {
        new UpdateOwnedItemAsyncTask(itemsOwnedDao).execute(itemsOwnedEntity);
    }

    public void deleteO(ItemsOwnedEntity itemsOwnedEntity) {
        new DeleteOwnedItemAsyncTask(itemsOwnedDao).execute(itemsOwnedEntity);
    }


    public LiveData<List<ItemsOwnedEntity>> getAllOwnedItems() {
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
        return allOwnedGauntlet;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedArmors() {
        return allOwnedArmors;
    }

    public LiveData<List<ItemsOwnedEntity>> getAllOwnedBoots() {
        return allOwnedBoots;
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

    private static class InsertOwnedItemAsyncTask extends AsyncTask<ItemsOwnedEntity, Void, Void> {

        private ItemsOwnedDao ItemsOwnedDao;

        private InsertOwnedItemAsyncTask(ItemsOwnedDao itemsOwnedDao) {
            this.ItemsOwnedDao = itemsOwnedDao;
        }

        @Override
        protected Void doInBackground(ItemsOwnedEntity... itemsOwnedEntities) {
            ItemsOwnedDao.insertO(itemsOwnedEntities[0]);
            return null;
        }
    }

    private static class UpdateOwnedItemAsyncTask extends AsyncTask<ItemsOwnedEntity, Void, Void> {

        private ItemsOwnedDao ItemsOwnedDao;

        private UpdateOwnedItemAsyncTask(ItemsOwnedDao itemsOwnedDao) {
            this.ItemsOwnedDao = itemsOwnedDao;
        }

        @Override
        protected Void doInBackground(ItemsOwnedEntity... itemsOwnedEntities) {
            ItemsOwnedDao.insertO(itemsOwnedEntities[0]);
            return null;
        }
    }

    private static class DeleteOwnedItemAsyncTask extends AsyncTask<ItemsOwnedEntity, Void, Void> {

        private ch.rpg.felix.rpg.Database.OwnedItems.ItemsOwnedDao ItemsOwnedDao;

        private DeleteOwnedItemAsyncTask(ItemsOwnedDao itemsOwnedDao) {
            this.ItemsOwnedDao = itemsOwnedDao;
        }

        @Override
        protected Void doInBackground(ItemsOwnedEntity... itemsOwnedEntities) {
            ItemsOwnedDao.insertO(itemsOwnedEntities[0]);
            return null;
        }
    }
}