package com.adryanev.dikamus.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Project: Dikamus
 *
 * @author Adryan Eka Vandra <adryanekavandra@gmail.com>
 * Date: 12/20/2018
 * Time: 6:46 PM
 */
public class SessionManager {

    private Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor  editor;
    private static final String PREF_NAME = "dikamus_preference";
    private static final String KEY_IS_FIRST = "isFirst";
    public SessionManager(Context context){
        sharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }
    public void setFirstLaunch(boolean isFirst){
        editor.putBoolean(KEY_IS_FIRST, isFirst);
        editor.commit();
    }
    public boolean isFirstLaunch(){
        return  sharedPreferences.getBoolean(KEY_IS_FIRST,true);
    }


}
