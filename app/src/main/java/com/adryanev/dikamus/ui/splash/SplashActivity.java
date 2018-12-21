package com.adryanev.dikamus.ui.splash;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.adryanev.dikamus.R;
import com.adryanev.dikamus.data.entity.EnglishIndonesia;
import com.adryanev.dikamus.ui.main.MainActivity;
import com.adryanev.dikamus.utils.SessionManager;
import com.adryanev.dikamus.utils.SnackBarUtils;

import java.util.List;

import timber.log.Timber;

public class SplashActivity extends AppCompatActivity {

    ViewModel viewModel;
    SessionManager sessionManager;
    CoordinatorLayout coordinatorLayout;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        coordinatorLayout = findViewById(R.id.splash_coordinator);
        progressBar = findViewById(R.id.splash_progress);
        Timber.d("Menjalankan SplashActivity");
        viewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        sessionManager = new SessionManager(this);
        final Intent i = new Intent(SplashActivity.this, MainActivity.class);
        if(sessionManager.isFirstLaunch()){
            Timber.d("First Time Launch, Generating Database");
            ((SplashViewModel) viewModel).search("a").observe(this, new Observer<List<EnglishIndonesia>>() {
                @Override
                public void onChanged(List<EnglishIndonesia> englishIndonesias) {
                    Timber.d("Generated");
                }
            });
            SnackBarUtils.showSnackBar(coordinatorLayout,"Sedang memuat Database");
            WorkManager.getInstance().getWorkInfosByTagLiveData("seed").observe(this, new Observer<List<WorkInfo>>() {
                @Override
                public void onChanged(List<WorkInfo> workInfos) {
                    WorkInfo currentWork = workInfos.get(0);
                    boolean isFinished = currentWork.getState().isFinished();
                    Timber.d("Working");
                    if(isFinished){
                        sessionManager.setFirstLaunch(false);
                        startActivity(i);
                        finish();
                    }

                }
            });


        }else{

            startActivity(i);
            finish();
        }



    }

}
