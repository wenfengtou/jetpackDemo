package cn.com.ava.jetpackdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import cn.com.ava.jetpackdemo.bean.Note;
import cn.com.ava.jetpackdemo.databinding.ActivityMainBinding;
import cn.com.ava.jetpackdemo.viewmodel.LoginViewModel;
import cn.com.ava.jetpackdemo.viewmodel.NoteViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private LoginViewModel mLoginViewModel;
    private ViewModelProvider mViewModelProvider;

    private NoteViewModel mNoteViewModel;
    private MutableLiveData<Note> mNoteLiveData;

    private TextView mMainTextView;
    private TextView mNormalTextView;
    private Note mNote;

    private int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       // startActivity(new Intent(this, LoginActivity.class));
       // mViewModelProvider = ViewModelProviders.of(this);
       // mLoginViewModel = mViewModelProvider.get(LoginViewModel.class);
       // startActivity(new Intent(this, LoginActivity.class));
       // subscribe();

        /*
        if (savedInstanceState != null) {
            Log.i(TAG, "销毁重建 mName=" + mLoginViewModel.getName());
        } else {
            mLoginViewModel.setName("fengtoutou");
            Log.i(TAG, "onCreate setName");
        }
        testInstance();
        testSingleLiveData();
         */
        mNoteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.setNoteViewModel(mNoteViewModel);
        binding.setLifecycleOwner(this);
        setContentView(binding.getRoot());
        mMainTextView = ((TextView) findViewById(R.id.tv_main));
        mNoteLiveData = new MutableLiveData<>();
        mNoteLiveData.setValue(new Note("Fuck", 22));
        mNoteViewModel.setNoteLiveData(mNoteLiveData);


        mMainTextView.setOnClickListener(view -> {
            //mNote.postValue(new Note("MNT", 200));
            mCount++;
            mNoteLiveData.setValue(new Note("ViewModel Object LiveData:" + mCount, 22));
            mNoteViewModel.getName().setValue("ViewModel int LiveData:" + mCount);
            mNoteViewModel.getAge().setValue(mCount);
            //mNoteViewModel.setNoteLiveData(mNoteLiveData);
        });

        //监听liveData变化
        mNoteViewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //Toast.makeText(MainActivity.this,"发生了改变：" + s, Toast.LENGTH_SHORT).show();
            }
        });

        /*
        mNoteViewModel.getAge().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Toast.makeText(MainActivity.this,"发生了改变：" + integer, Toast.LENGTH_SHORT).show();
            }
        });
         */

        /*
        mNote = new Note("Hi", 22);
        mNoteLiveData.setValue(mNote);
        mMainTextView.setOnClickListener(view -> {
            //mNote.postValue(new Note("MNT", 200));
            mCount++;
            Note note = mNoteLiveData.getValue();
            note.setAuthor("hehe");
        });
         */

    }

    private MutableLiveData<Long> mSingleLiveData = new MutableLiveData<>();

    class Human {

    }

    class Woman extends Human {

    }

    private void testInstance() {
        Human meiMeiHan = new Human();
        if (meiMeiHan instanceof Woman) {
            Log.i(TAG, "meiMeiHan instanceof Woman2");
        }

        if (meiMeiHan instanceof Human) {
            Log.i(TAG, "meiMeiHan instanceof Human2");
        }

        Log.i(TAG, "meiMeiHan class =" + meiMeiHan.getClass());

        if (Human.class.isInstance(meiMeiHan)) {
            Log.i(TAG, "Human.class.isInstance(meiMeiHan)");
        }

        if (Woman.class.isInstance(meiMeiHan)) {
            Log.i(TAG, "Woman.class.isInstance(meiMeiHan)");
        }

    }

    //不依赖ViewModel，单独使用LiveData
    private void testSingleLiveData() {
        mSingleLiveData.observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                ((TextView) findViewById(R.id.tv_main)).setText("test:" + aLong);
            }
        });
        Timer timer = new Timer();

        // Update the elapsed time every second.
        final long[] testNum = {0};
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                testNum[0]++;
                // setValue() cannot be called from a background thread so post to main thread.
                mSingleLiveData.postValue(testNum[0]);
            }
        }, 1000, 1000);
    }

    private void subscribe() {
        final Observer<Long> elapsedTimeObserver = new Observer<Long>() {
            @Override
            public void onChanged(@Nullable final Long aLong) {
                String newText = MainActivity.this.getResources().getString(
                        R.string.seconds, aLong);
                ((TextView) findViewById(R.id.tv_main)).setText(newText);
                Log.d("ChronoActivity3", "Updating timer");
            }
        };
        //
        mLoginViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
}
