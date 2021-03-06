package com.adryanev.dikamus.ui.main.indonesia_english;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import com.adryanev.dikamus.data.AppRepository;
import com.adryanev.dikamus.data.entity.IndonesiaEnglish;

import java.util.List;

public class IndonesiaEnglishViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<List<IndonesiaEnglish>> inEnList;
    public IndonesiaEnglishViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
    }
    public LiveData<List<IndonesiaEnglish>> search(String kata){
        inEnList = repository.searchKataEnglish(kata);
        return inEnList;
    }
}
