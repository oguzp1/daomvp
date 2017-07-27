package com.example.paksoy.daomvp.di;


import android.app.Application;
import android.content.Context;

import com.example.paksoy.daomvp.MainApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MONSTER on 5.7.2017.
 */

@Module
public class AppModule {

    private  MainApp mainApp;

    public AppModule(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return mainApp.getApplicationContext();
    }

    @Provides
    @Singleton
    MainApp provideApplication() {
        return mainApp;
    }
}
