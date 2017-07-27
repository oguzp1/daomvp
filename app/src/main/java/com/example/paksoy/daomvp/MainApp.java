package com.example.paksoy.daomvp;

import android.app.Application;

import com.example.paksoy.daomvp.di.AppComponent;
import com.example.paksoy.daomvp.di.AppModule;
import com.example.paksoy.daomvp.di.DaggerAppComponent;
import com.example.paksoy.daomvp.di.DatabaseModule;
import com.example.paksoy.daomvp.main.MainComponent;

/**
 * Created by MONSTER on 5.7.2017.
 */

public class MainApp extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .databaseModule(new DatabaseModule())
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
