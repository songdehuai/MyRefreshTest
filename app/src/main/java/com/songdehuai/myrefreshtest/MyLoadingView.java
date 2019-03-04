package com.songdehuai.myrefreshtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.songdehuai.widget.myrefreshlayout.IBottomView;
import com.songdehuai.widget.myrefreshlayout.R;
import com.songdehuai.widget.myrefreshlayout.utils.DensityUtil;

/**
 * 描述：
 *
 * @author songdehuai
 * @ClassName: com.songdehuai.myrefreshlayout.widget.refresh.footer.LoadingView
 * @date 2017/8/14 11:10
 */
@SuppressLint("AppCompatCustomView")
public class MyLoadingView extends LinearLayout implements IBottomView {

    public MyLoadingView(Context context) {
        this(context, null);
    }

    public MyLoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyLoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        int size = DensityUtil.dp2px(context, 40);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, size);
        TextView textView = new TextView(context);
        textView.setLayoutParams(layoutParams);
        textView.setGravity(Gravity.CENTER);
        textView.setText("加载更多");
        addView(textView);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingUp(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public void reset() {

    }
}
