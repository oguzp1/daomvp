package com.example.paksoy.daomvp.detail;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paksoy.daomvp.MainApp;
import com.example.paksoy.daomvp.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.edit_text)
    EditText editText;

    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        DaggerDetailComponent.builder()
                .appComponent(((MainApp) getApplication()).getAppComponent())
                .detailModule(new DetailModule(this))
                .build()
                .inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_note, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save_note:
                putNote();
                break;
        }
        return true;
    }

    private void putNote() {
        detailPresenter.saveNote(editText.getText().toString());
    }

    @Override
    public void saveSuccess() {
        setResult(Activity.RESULT_OK);
        finish();
    }

    @Override
    public void saveFail() {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
    }
}