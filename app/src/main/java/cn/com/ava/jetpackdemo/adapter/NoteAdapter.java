package cn.com.ava.jetpackdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.com.ava.jetpackdemo.R;
import cn.com.ava.jetpackdemo.bean.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private ArrayList<Note> mNoteList = new ArrayList<>();
    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return mNoteList.size();
    }

    public void setNoteList(ArrayList<Note> noteList) {
        mNoteList.addAll(noteList);
        notifyDataSetChanged();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView mTimeTextView;
        TextView mContentTextView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            mTimeTextView = itemView.findViewById(R.id.tv_time);
            mContentTextView = itemView.findViewById(R.id.tv_content);
        }
    }
}
