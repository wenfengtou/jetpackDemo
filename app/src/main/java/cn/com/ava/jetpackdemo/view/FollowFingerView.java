package cn.com.ava.jetpackdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FollowFingerView extends View {

    private float mMoveX;
    private float mMoveY;

    public FollowFingerView(Context context) {
        super(context);
    }

    public FollowFingerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FollowFingerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FollowFingerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mMoveX = event.getX();
                mMoveY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //setTranslationX(getX() + (event.getX() - mMoveX));
                //setTranslationY(getY() + (event.getY() - mMoveY));

                /*
                // 计算偏移量
                int offsetX = (int)(event.getX() - mMoveX);
                int offsetY = (int)(event.getY() - mMoveY);
                // 在当前left、top、right、bottom的基础上加上偏移量
                layout(getLeft() + offsetX,
                        getTop() + offsetY,
                        getRight() + offsetX,
                        getBottom() + offsetY);
                 */

                int offsetX = (int)(event.getX() - mMoveX);
                int offsetY = (int)(event.getY() - mMoveY);
                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;
                setLayoutParams(layoutParams);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }

        return true;
    }
}
