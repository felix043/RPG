package ch.rpg.felix.rpg.Item;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

@Database(entities = Item.class, version = 1)
public abstract class ItemDatabase extends RoomDatabase {

    private static ItemDatabase instance;
    private static RoomDatabase.Callback itemCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

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

    public abstract ItemDao itemDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ItemDao itemDao;

        private PopulateDbAsyncTask(ItemDatabase db) {
            itemDao = db.itemDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.insert(new Item("Wooden Sword", "A sturdy wooden sword", 3, 1));
            itemDao.insert(new Item("Bronze Sword", "An old bronze sword", 5, 1));
            itemDao.insert(new Item("Iron Sword", "A sharp iron sword", 8, 1));
            return null;
        }
    }
}
