package com.example.paksoy.daomvp.main;

import com.example.paksoy.daomvp.model.Note;

import java.util.List;

/**
 * Created by MONSTER on 5.7.2017.
 */

public interface MainView {
    void resetAdapter(List<Note> noteList);

    void showList(List<Note> noteList);
}
