package com.example.paksoy.daomvp.di;

import android.content.Context;

import com.example.paksoy.daomvp.model.DaoMaster;
import com.example.paksoy.daomvp.model.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MONSTER on 5.7.2017.
 */

@Module
public class DatabaseModule {
    @Provides
    @Singleton
    DaoSession provideDaoSession(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "notes-db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }
}
