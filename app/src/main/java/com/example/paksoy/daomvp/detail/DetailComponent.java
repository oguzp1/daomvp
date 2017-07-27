package com.example.paksoy.daomvp.detail;

import com.example.paksoy.daomvp.di.ActivityScope;
import com.example.paksoy.daomvp.di.AppComponent;

import dagger.Component;

/**
 * Created by MONSTER on 5.7.2017.
 */

@ActivityScope
@Component(modules = {DetailModule.class}, dependencies = {AppComponent.class})
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
