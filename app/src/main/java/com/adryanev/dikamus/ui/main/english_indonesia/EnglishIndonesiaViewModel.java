package com.adryanev.dikamus.ui.main.english_indonesia;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.adryanev.dikamus.data.AppRepository;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;

import java.util.List;

public class EnglishIndonesiaViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<List<EnglishIndonesia>> enInList;
    public EnglishIndonesiaViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }

    public LiveData<List<EnglishIndonesia>> search(String kata){
        enInList = repository.searchKataIndo(kata);
        return enInList;
    }}
