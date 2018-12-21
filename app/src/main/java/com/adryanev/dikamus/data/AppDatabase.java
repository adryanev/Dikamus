package com.adryanev.dikamus.data;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.adryanev.dikamus.R;
import com.adryanev.dikamus.worker.PopulateDatabaseWorker;
import com.adryanev.dikamus.data.dao.EnglishIndonesiaDao;
import com.adryanev.dikamus.data.dao.IndonesiaEnglishDao;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;
import com.adryanev.dikamus.data.entity.IndonesiaEnglish;


import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import timber.log.Timber;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 6:00 PM
 */
@Database(entities = {EnglishIndonesia.class, IndonesiaEnglish.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EnglishIndonesiaDao enInDao();
    public abstract IndonesiaEnglishDao inEnDao();
    static String tag = "seed";
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    Timber.d("Creating Database");
                    INSTANCE = buildDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    private static AppDatabase buildDatabase(Context context) {
        Timber.d("Building, Room");
        return Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"dikamus_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .addCallback(roomDatabaseCallback)
                .build();

    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Timber.d("onOpen Sqlite");
            Timber.d("Statring PopulateDatabaseWorker");
            OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(PopulateDatabaseWorker.class).addTag(tag).build();

            WorkManager wm =  WorkManager.getInstance();
            wm.enqueue(request);


        }

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };

}
