package com.adryanev.dikamus.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.adryanev.dikamus.worker.PopulateDatabaseWorker;
import com.adryanev.dikamus.data.dao.EnglishIndonesiaDao;
import com.adryanev.dikamus.data.dao.IndonesiaEnglishDao;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;
import com.adryanev.dikamus.data.entity.IndonesiaEnglish;

import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 6:00 PM
 */
@Database(entities = {EnglishIndonesia.class, IndonesiaEnglish.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EnglishIndonesiaDao enInDao();
    public abstract IndonesiaEnglishDao inEnDao();
    private static WorkManager workManager = WorkManager.getInstance();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (AppDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"app_database")
                            .fallbackToDestructiveMigration().addCallback(roomDatabaseCallback).build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(PopulateDatabaseWorker.class).build();
            workManager.enqueue(request);
        }
    };

}
