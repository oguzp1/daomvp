package com.example.paksoy.daomvp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.paksoy.daomvp.MainApp;
import com.example.paksoy.daomvp.R;
import com.example.paksoy.daomvp.main.adapter.CustomAdapter;
import com.example.paksoy.daomvp.model.Note;
import com.example.paksoy.daomvp.detail.DetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    public static final int REQUEST_CODE = 1;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    MainPresenter presenter;

    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        DaggerMainComponent.builder()
                .appComponent(((MainApp) getApplication()).getAppComponent())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);


        presenter.getNoteList();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_note:
                Intent i = new Intent(this, DetailActivity.class);
                startActivityForResult(i, REQUEST_CODE);
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            presenter.resetView();
        }
    }

    @Override
    public void resetAdapter(List<Note> noteList) {
        ((CustomAdapter) recyclerView.getAdapter()).updateAdapter(noteList);
    }

    @Override
    public void showList(List<Note> noteList) {
        if (adapter == null) {
            adapter = new CustomAdapter(noteList);
        }
        recyclerView.setAdapter(adapter);
    }
}
