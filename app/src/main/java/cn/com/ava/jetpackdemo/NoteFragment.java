package cn.com.ava.jetpackdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.com.ava.jetpackdemo.R;
import cn.com.ava.jetpackdemo.adapter.NoteAdapter;
import cn.com.ava.jetpackdemo.bean.Note;


//使用两层dialog，一层输入，一层详情
public class NoteFragment extends BottomSheetDialogFragment {

    private static final String TAG = "NoteFragment";


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Log.i(TAG, "onCreateDialog");
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
       // BottomSheetDialog dialog = (BottomSheetDialog) getDialog();
       // dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //dialog.getbe.setPeekHeight((int) (screenHeight*0.7), true);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        View view = inflater.inflate(R.layout.note_main, container, false);
        RecyclerView noteRecyclerView = view.findViewById(R.id.rv_note);
        NoteAdapter noteAdapter = new NoteAdapter();
        noteRecyclerView.setAdapter(noteAdapter);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        noteAdapter.setNoteList(fetchNoteList());
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
