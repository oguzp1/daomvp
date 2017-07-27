package com.example.paksoy.daomvp.detail;

import com.example.paksoy.daomvp.model.DaoSession;
import com.example.paksoy.daomvp.model.Note;

import javax.inject.Inject;

/**
 * Created by MONSTER on 5.7.2017.
 */

public class DetailPresenter {
    private DaoSession daoSession;

    private DetailView detailView;

    @Inject
    public DetailPresenter(DaoSession daoSession, DetailView detailView) {
        this.daoSession = daoSession;
        this.detailView = detailView;
    }

    public void saveNote(String s) {
        Note note = new Note();
        note.setNote(s);
        long temp = daoSession.getNoteDao().insert(note);
        if (temp > 0)
            detailView.saveSuccess();
        else
            detailView.saveFail();
    }
}
