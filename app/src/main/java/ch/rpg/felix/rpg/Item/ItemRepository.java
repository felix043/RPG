package ch.rpg.felix.rpg.Item;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ItemRepository {

    private ItemDao itemDao;
    private LiveData<List<Item>> allItems;

    public ItemRepository(Application application) {
        ItemDatabase db = ItemDatabase.getInstance(application);
        itemDao = db.itemDao();
        allItems = itemDao.getAllItems();
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
