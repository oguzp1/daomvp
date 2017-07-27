package com.example.paksoy.daomvp.main;

import com.example.paksoy.daomvp.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MONSTER on 5.7.2017.
 */

@Module
public class MainModule {

    private MainView mainView;

    public MainModule(MainView view) {
        this.mainView = view;
    }

    @Provides
    @ActivityScope
    MainView provideView() {
        return mainView;
    }
}
