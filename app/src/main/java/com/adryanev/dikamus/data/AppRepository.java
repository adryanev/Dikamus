package com.adryanev.dikamus.data;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.adryanev.dikamus.data.dao.EnglishIndonesiaDao;
import com.adryanev.dikamus.data.dao.IndonesiaEnglishDao;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;
import com.adryanev.dikamus.data.entity.IndonesiaEnglish;

import java.util.List;

import timber.log.Timber;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 7:30 PM
 */
public class AppRepository {
    private EnglishIndonesiaDao enInDao;
    private IndonesiaEnglishDao inEnDao;
    private LiveData<List<EnglishIndonesia>> enInList;
    private LiveData<List<IndonesiaEnglish>> inEnList;
    private LiveData<EnglishIndonesia> enIn;
    private LiveData<IndonesiaEnglish> inEn;

    public AppRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        enInDao = db.enInDao();
        inEnDao = db.inEnDao();
        Timber.d("Db isOpen: %b", db.isOpen());

    }

    public LiveData<List<EnglishIndonesia>> searchKataIndo(String text){
        enInList = enInDao.search(text);
        return enInList;
    }
    public LiveData<List<IndonesiaEnglish>> searchKataEnglish(String text){
        inEnList = inEnDao.search(text);
        return inEnList;
    }
    public LiveData<EnglishIndonesia> getEnIn(String text){
        enIn = enInDao.getTerjemahan(text);
        return enIn;
    }
    public LiveData<IndonesiaEnglish> getInEn(String text){
        inEn = inEnDao.getTerjemahan(text);
        return inEn;
    }


}
