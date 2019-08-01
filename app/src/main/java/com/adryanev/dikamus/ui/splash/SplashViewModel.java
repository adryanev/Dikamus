package com.adryanev.dikamus.ui.splash;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.adryanev.dikamus.data.AppDatabase;
import com.adryanev.dikamus.data.AppRepository;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;

import java.util.List;

import timber.log.Timber;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/21/2018
 * Time: 4:00 PM
 */
public class SplashViewModel extends AndroidViewModel {

    AppRepository repository;
    LiveData<List<EnglishIndonesia>> listKata;
    public SplashViewModel(@NonNull Application application) {
        super(application);
       repository = new AppRepository(application);

    }
   public LiveData<List<EnglishIndonesia>> search(String kata){
        listKata = repository.searchKataIndo(kata);
        return listKata;
    }

}
