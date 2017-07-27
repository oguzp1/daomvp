package com.example.paksoy.daomvp.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.paksoy.daomvp.R;
import com.example.paksoy.daomvp.model.Note;

import java.util.List;

/**
 * Created by MONSTER on 5.7.2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Note> listNote;

    public CustomAdapter(List<Note> listNote) {
        this.listNote = listNote;
    }

    public void updateAdapter(List<Note> listNote) {
        this.listNote = listNote;

        notifyDataSetChanged();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_data, parent, false);

        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final Note curNote = listNote.get(position);

        holder.textView.setText(curNote.getNote());

    }

    @Override
    public int getItemCount() {
        return listNote.size();
    }


    static class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        public CustomViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.screen_message);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), textView.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
