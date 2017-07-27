package com.example.paksoy.daomvp.di;


import android.content.Context;

import com.example.paksoy.daomvp.model.DaoSession;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by MONSTER on 5.7.2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        DatabaseModule.class})
public interface AppComponent {

    DaoSession session();

    Context context();


}
