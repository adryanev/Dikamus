package com.adryanev.dikamus;

import android.app.Application;

import timber.log.Timber;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 6:23 PM
 */
public class DikamusApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
