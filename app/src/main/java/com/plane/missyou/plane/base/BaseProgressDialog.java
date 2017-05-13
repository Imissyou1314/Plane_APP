package com.plane.missyou.plane.base;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.widget.ProgressBar;

import com.plane.missyou.plane.R;

/**
 * Created by MissC on 2017/5/5.
 */

public class BaseProgressDialog extends Dialog {
    
    public static BaseProgressDialog newInstance(Context context) {
        return new BaseProgressDialog(context);
    }
    
    public BaseProgressDialog(@NonNull Context context) {
        this(context, R.style.progress_dialog);
        initUI();
    }

    public BaseProgressDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        initUI();
    }

    protected BaseProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initUI();
    }

    private void initUI() {
        setContentView(new ProgressBar(getContext()));
        getWindow().getAttributes().gravity = Gravity.CENTER;
        setCanceledOnTouchOutside(false);
    }
}
