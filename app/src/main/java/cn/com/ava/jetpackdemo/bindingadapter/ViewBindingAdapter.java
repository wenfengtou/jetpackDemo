package cn.com.ava.jetpackdemo.bindingadapter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

public final class ViewBindingAdapter {
    private static final String TAG = "ViewBindingAdapter";
    @BindingAdapter("clickCommandBind")
    public static void clickCommand(View view , final String clickCommand) {
        if(clickCommand == null) {
            return;
        }
        view.setOnClickListener(clickview -> {
            Log.i(TAG, "setOnClickListener" + clickCommand);
        });
    }
}
