package com.example.paksoy.daomvp.main;

import com.example.paksoy.daomvp.di.ActivityScope;
import com.example.paksoy.daomvp.di.AppComponent;

import dagger.Component;

/**
 * Created by MONSTER on 5.7.2017.
 */
@ActivityScope
@Component(modules = {MainModule.class}, dependencies = {AppComponent.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
