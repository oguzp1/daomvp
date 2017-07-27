package com.example.paksoy.daomvp.detail;

import com.example.paksoy.daomvp.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MONSTER on 5.7.2017.
 */

@Module
public class DetailModule {
    private DetailView detailView;

    public DetailModule(DetailView detailView) {
        this.detailView = detailView;
    }

    @ActivityScope
    @Provides
    DetailView provideDetailView() {
        return detailView;
    }
}
