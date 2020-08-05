package cn.com.ava.jetpackdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import cn.com.ava.jetpackdemo.adapter.NoteAdapter;
import cn.com.ava.jetpackdemo.bean.Note;

public class NoteFragment extends BottomSheetDialogFragment {

    private static final String TAG = "NoteFragment";
    BottomSheetDialog mBottomSheetDialog;
    BottomSheetBehavior mBottomSheetBehavior;
    private NoteAdapter mNoteAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.note_main, container, false);

        RecyclerView noteRecyclerView = view.findViewById(R.id.rv_note);
        mNoteAdapter = new NoteAdapter();
        noteRecyclerView.setAdapter(mNoteAdapter);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        mNoteAdapter.setNoteList(fetchNoteList());

        /*
        mBottomSheetDialog = new BottomSheetDialog(getContext());
        mBottomSheetDialog.setContentView(view);

        mBottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        mBottomSheetBehavior.setPeekHeight(300);

        mBottomSheetBehavior.setHideable(false);

        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int newState) {
                Log.i(TAG, "onStateChanged:" + newState);
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                Log.i(TAG, "onSlide");
            }
        });
         */
        //view = inflater.inflate(R.layout.fragment_hello, null);
        return view;
    }

    private ArrayList<Note> fetchNoteList() {
        ArrayList<Note> noteList = new ArrayList<>();
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        noteList.add(new Note("1", 1));
        return noteList;
    }

}
