package cn.com.ava.jetpackdemo.bindingadapter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BindingAdapter;

/*给view绑定一些初始化操作*/
public final class ViewBindingAdapter {
    private static final String TAG = "ViewBindingAdapter";
    @BindingAdapter("clickCommandBind")
    public static void clickCommand(View view , final String clickCommand) {
        if(clickCommand == null) {
            return;
        }
        /*
        view.setOnClickListener(clickview -> {
            Log.i(TAG, "setOnClickListener" + clickCommand);
        });
         */
    }
    @BindingAdapter("initBindHehe")
    public static int initHehe(View view, final String initCommand) {
        view.setOnClickListener(clickview -> {
            Log.i(TAG, "onclick!!");
        });
        return 1;
    }
}
