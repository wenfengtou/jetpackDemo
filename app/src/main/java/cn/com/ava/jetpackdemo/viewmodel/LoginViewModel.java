package cn.com.ava.jetpackdemo.viewmodel;

import android.os.SystemClock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

/*貌似没有什么用？，莫非是架构需要？*/
/*可以感知生命周期，用于保存数据，例如Activity销毁的时候*/
public class LoginViewModel extends ViewModel {
    private String mName;
    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();
    private long mInitialTime;

    public LoginViewModel() {
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        // Update the elapsed time every second.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = (SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                // setValue() cannot be called from a background thread so post to main thread.
                mElapsedTime.postValue(newValue);
            }
        }, 1000, 1000);
    }

    public LiveData<Long> getElapsedTime() {
        return mElapsedTime;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}
