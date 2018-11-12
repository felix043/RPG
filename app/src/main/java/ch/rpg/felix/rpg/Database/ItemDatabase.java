package ch.rpg.felix.rpg.Database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

@Database(entities = {Item.class, ItemsOwnedEntity.class}, version = 6)
public abstract class ItemDatabase extends RoomDatabase {

    private static RoomDatabase.Callback itemCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateItemAsyncTask(instance).execute();
            new PopulateItemsOwnedAsyncTask(instance).execute();
        }
    };

    public abstract ItemDao itemDao();

    private static ItemDatabase instance;

    public abstract ItemsOwnedDao itemsOwnedDao();

    public static synchronized ItemDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ItemDatabase.class, "item_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(itemCallback)
                    .build();
        }
        return instance;
    }

    private static class PopulateItemAsyncTask extends AsyncTask<Void, Void, Void> {
        private ItemDao itemDao;

        private PopulateItemAsyncTask(ItemDatabase db) {
            itemDao = db.itemDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.insert(new Item(1, "Wooden Sword", "A sturdy wooden sword", 3, 1, 0, 25, 0, 0));
            itemDao.insert(new Item(1, "Bronze Sword", "An old bronze sword", 5, 1, 0, 55, 0, 0));
            itemDao.insert(new Item(1, "Iron Sword", "A sharp iron sword", 8, 1, 45, 4, 0, 0));
            itemDao.insert(new Item(3, "Leather Helmet", "Tough leather helmet", 0, 1, 2, 15, 0, 0));
            itemDao.insert(new Item(2, "Wooden Shield", "Weak wooden shield", 0, 1, 3, 10, 0, 0));
            itemDao.insert(new Item(4, "Leather Gauntlet", "Tough leather gauntlet", 0, 1, 2, 15, 0, 0));
            itemDao.insert(new Item(5, "Leather Armor", "Tough leather armor", 0, 1, 5, 25, 0, 0));
            itemDao.insert(new Item(6, "Leather Boots", "Tough leather boots", 0, 1, 3, 15, 0, 0));

            itemDao.insert(new Item(1, "Fullen Biscuit", "Tough cookie", -5, 1, 5, 10, 10, 10));

            return null;
        }
    }

    private static class PopulateItemsOwnedAsyncTask extends AsyncTask<Void, Void, Void> {
        private ItemsOwnedDao itemsOwnedDao;

        private PopulateItemsOwnedAsyncTask(ItemDatabase db) {
            itemsOwnedDao = db.itemsOwnedDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemsOwnedDao.insertO(new ItemsOwnedEntity(1, "Wooden Sword", "A sturdy wooden sword", 3, 1, 0, 25, 0, 0));
            itemsOwnedDao.insertO(new ItemsOwnedEntity(1, "Bronze Sword", "An old bronze sword", 5, 1, 0, 55, 0, 0));
            itemsOwnedDao.insertO(new ItemsOwnedEntity(2, "Wooden Shield", "Weak wooden shield", 0, 1, 3, 10, 0, 0));
            itemsOwnedDao.insertO(new ItemsOwnedEntity(3, "Leather Helmet", "Tough leather helmet", 0, 1, 2, 15, 0, 0));
            itemsOwnedDao.insertO(new ItemsOwnedEntity(4, "Leather Gauntlet", "Tough leather gauntlet", 0, 1, 2, 15, 0, 0));
            itemsOwnedDao.insertO(new ItemsOwnedEntity(5, "Leather Armor", "Tough leather armor", 0, 1, 5, 25, 0, 0));
            itemsOwnedDao.insertO(new ItemsOwnedEntity(6, "Leather Boots", "Tough leather boots", 0, 1, 3, 15, 0, 0));

            return null;
        }
    }
}