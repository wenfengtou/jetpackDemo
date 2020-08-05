package cn.com.ava.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class SettingActivity extends FragmentActivity {

    NoteFragment noteFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        /*
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.note_fragment_container,new NoteFragment())   // 此处的R.id.fragment_container是要盛放fragment的父容器
                .commit();
         */


        /*
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(new NoteFragment(), "nav_topic");
        ft.commit();
         */


        noteFragment = new NoteFragment();
        noteFragment.show(getSupportFragmentManager(),"nav_topic");


    }
}