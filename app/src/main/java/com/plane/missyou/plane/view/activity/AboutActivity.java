package com.plane.missyou.plane.view.activity;

import android.view.View;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.plane.missyou.plane.R;
import com.plane.missyou.plane.base.BaseActivity;
import com.plane.missyou.plane.entity.EventMessage;
import com.plane.missyou.plane.utils.SystemUtils;

import butterknife.BindView;

public class AboutActivity extends BaseActivity {

    @BindView(R.id.about_author_phone)
    TextView callText;
    @BindView(R.id.about_author_name)
    TextView userName;
    @BindView(R.id.author_rcode_image)
    RoundedImageView userHandImageView;

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addListeners() {
        callText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhoen();
            }
        });
    }

    @Override
    public void onEventMessage(EventMessage em) {

    }

    private void callPhoen() {
        SystemUtils.call(context , callText.getText().toString());
    }

    @Override
    public int inflaterRootView() {
        return R.layout.activity_about;
    }
}
