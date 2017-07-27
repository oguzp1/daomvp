package com.example.paksoy.daomvp.main;

import com.example.paksoy.daomvp.model.DaoSession;
import com.example.paksoy.daomvp.model.Note;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by MONSTER on 5.7.2017.
 */

public class MainPresenter {

    private DaoSession daoSession;
    private MainView mainView;

    @Inject
    public MainPresenter(DaoSession daoSession, MainView mainView) {
        this.daoSession = daoSession;
        this.mainView = mainView;
    }

    public void resetView() {
        List<Note> noteList = daoSession.getNoteDao().loadAll();
        mainView.resetAdapter(noteList);
    }

    public void getNoteList() {
        List<Note> noteList = new ArrayList<>(daoSession.getNoteDao().loadAll());
        mainView.showList(noteList);
    }
}
