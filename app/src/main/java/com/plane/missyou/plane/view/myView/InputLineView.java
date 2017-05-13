package com.plane.missyou.plane.view.myView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.plane.missyou.plane.R;

/**
 * Created by MissC on 2017/5/12.
 */

public class InputLineView extends LinearLayout {

    private TextView titleView;
    private EditText inputView;

    public InputLineView(Context context) {
        this(context, null);
    }

    public InputLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.miss_input_view, this, true);
        titleView = (TextView) findViewById(R.id.miss_input_view_title);
        inputView = (EditText) findViewById(R.id.miss_input_view_context);
    }

    public void setTitleView(String title) {
        titleView.setText(title);
    }

    public void setTitleView(int resId) {
        titleView.setText(resId);
    }

    public String getInput() {
        return inputView.getText().toString();
    }

    public void initInputView() {
        inputView.setText("");
    }

    public void setInputHint(String hint) {
        inputView.setHint(hint);
    }

    public void setInputHint(int resId) {
        inputView.setHint(resId);
    }
}
