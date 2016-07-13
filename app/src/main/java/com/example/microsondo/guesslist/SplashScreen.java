package com.example.microsondo.guesslist;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by michaelpinchin on 16-06-21.
 */
public class SplashScreen extends Application
{
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
