package cn.com.ava.jetpackdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ActionMenuView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import cn.com.ava.jetpackdemo.modules.login.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private LoginViewModel mLoginViewModel;
    private ViewModelProvider mViewModelProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // startActivity(new Intent(this, LoginActivity.class));
        mViewModelProvider = ViewModelProviders.of(this);
        mLoginViewModel = mViewModelProvider.get(LoginViewModel.class);
       // startActivity(new Intent(this, LoginActivity.class));
       // subscribe();

        if (savedInstanceState != null) {
            Log.i(TAG, "销毁重建 mName=" + mLoginViewModel.getName());
        } else {
            mLoginViewModel.setName("fengtoutou");
            Log.i(TAG, "onCreate setName");
        }
        testInstance();
        testSingleLiveData();
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
                ((TextView) findViewById(R.id.timer_textview)).setText("test:" + aLong);
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
                ((TextView) findViewById(R.id.timer_textview)).setText(newText);
                Log.d("ChronoActivity3", "Updating timer");
            }
        };
        //
        mLoginViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }
}
