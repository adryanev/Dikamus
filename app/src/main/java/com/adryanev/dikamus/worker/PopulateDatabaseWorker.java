package com.adryanev.dikamus.worker;

import android.content.Context;
import androidx.annotation.NonNull;

import com.adryanev.dikamus.data.AppDatabase;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;
import com.adryanev.dikamus.data.entity.IndonesiaEnglish;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import androidx.work.Worker;
import androidx.work.WorkerParameters;
import timber.log.Timber;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 6:10 PM
 */
public class PopulateDatabaseWorker extends Worker {
    private Context context;
    private List<EnglishIndonesia> enInList = new ArrayList<>();
    private List<IndonesiaEnglish> inEnList = new ArrayList<>();
    private AppDatabase database = AppDatabase.getDatabase(getApplicationContext());


    public PopulateDatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Timber.d("Starting PopulateDatabaseWorker");
        try {
            InputStream enInStream = getApplicationContext().getAssets().open("english_indonesia");
            Timber.d("enInStream: %s",enInStream.toString());
            InputStream inEnStream = getApplicationContext().getAssets().open("indonesia_english");

            BufferedReader enInReader = new BufferedReader(new InputStreamReader(enInStream));
            BufferedReader inEnReader = new BufferedReader(new InputStreamReader(inEnStream));

            String enInLine;
            Timber.d("Reading File");
            while ((enInLine = enInReader.readLine()) != null){
                String[] split = enInLine.split("\t");
                EnglishIndonesia data = new EnglishIndonesia(split[0],split[1]);
                enInList.add(data);
            }
            String inEnLine;
            while((inEnLine = inEnReader.readLine()) != null){
                String[] split = inEnLine.split("\t");
                IndonesiaEnglish data = new IndonesiaEnglish(split[0],split[1]);
                inEnList.add(data);
            }

            Timber.d("Insert to Database");
            database.enInDao().insertList(enInList);
            database.inEnDao().insertList(inEnList);
            Timber.d("Success");

            enInReader.close();
            inEnReader.close();
            enInStream.close();
            inEnStream.close();

            return Result.success();
        }
        catch (Throwable throwable){
            Timber.e(throwable);
           return Result.failure();
        }
    }
}
