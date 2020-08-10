package cn.com.ava.jetpackdemo.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import cn.com.ava.jetpackdemo.view.FollowFingerView;

public class FollowBehavior extends CoordinatorLayout.Behavior<Button> {


    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent, @NonNull Button child, @NonNull View dependency) {
        return dependency instanceof FollowFingerView;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent, @NonNull Button child, @NonNull View dependency) {
        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = left;
        int y = top + 50;

        setPosition(child, x, y);
        return true;
    }

    private void setPosition(View v, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) v.getLayoutParams();
        layoutParams.leftMargin = x;
        //layoutParams.topMargin = y;
        v.setLayoutParams(layoutParams);
    }
}
