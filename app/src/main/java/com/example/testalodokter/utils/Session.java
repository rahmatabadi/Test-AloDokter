package com.example.testalodokter.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "SESSION";

    //key
    String status = "status";

    public Session(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public String getStatus() {
        return preferences.getString(status,"false");
    }

    public void setStatus(String value) {
        editor.putString(status, value);
        editor.commit();
    }
}
