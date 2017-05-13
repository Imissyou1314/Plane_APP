package com.plane.missyou.plane.view.myView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.plane.missyou.plane.R;

/**
 * Created by MissC on 2017/5/12.
 */

public class TextLineView extends LinearLayout {

    private TextView titleView;
    private TextView contextView;

    public TextLineView(Context context) {
        this(context, null);
    }

    public TextLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.miss_show_line_view, this, true);
        titleView = (TextView) findViewById(R.id.miss_show_view_title);
        contextView = (TextView) findViewById(R.id.miss_show_view_context);
    }

    public void setTitleView(String title) {
        titleView.setText(title);
    }

    public void setTitleView(int resId) {
        titleView.setText(resId);
    }
    public void setContextView(String title) {
        titleView.setText(title);
    }

    public void setContextView(int resId) {
        titleView.setText(resId);
    }
}
