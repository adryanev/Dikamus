package com.adryanev.dikamus.worker;

import android.content.Context;
import android.support.annotation.NonNull;

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
    private Context context = getApplicationContext();
    List<EnglishIndonesia> enInList = new ArrayList<>();
    List<IndonesiaEnglish> inEnList = new ArrayList<>();
    BufferedReader enInReader;
    BufferedReader inEnReader;
    InputStream enInStream;
    InputStream inEnStream;
    AppDatabase database = AppDatabase.getDatabase(context);


    public PopulateDatabaseWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Timber.d("Starting PopulateDatabaseWorker");
        try {
             enInStream = context.getAssets().open("english_indonesia");
             inEnStream = context.getAssets().open("indonesia_english");

            enInReader = new BufferedReader(new InputStreamReader(enInStream));
            inEnReader = new BufferedReader(new InputStreamReader(inEnStream));

            String enInLine = null;
            Timber.d("Reading File");
            do{
                enInLine = enInReader.readLine();
                String[] split = enInLine.split("\t");
                EnglishIndonesia data = new EnglishIndonesia(split[0],split[1]);
                enInList.add(data);


            }while (enInLine != null);
            String inEnLine = null;
            do{
                inEnLine = inEnReader.readLine();
                String[] split = inEnLine.split("\t");
                IndonesiaEnglish data = new IndonesiaEnglish(split[0],split[1]);
                inEnList.add(data);
            }while (inEnLine != null);
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
