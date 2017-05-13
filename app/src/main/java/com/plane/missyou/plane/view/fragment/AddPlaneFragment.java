package com.plane.missyou.plane.view.fragment;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.plane.missyou.plane.R;
import com.plane.missyou.plane.base.BaseFragment;
import com.plane.missyou.plane.entity.EventMessage;
import com.plane.missyou.plane.view.myView.InputLineView;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AddPlaneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPlaneFragment extends BaseFragment {
    @BindView(R.id.add_plane_input_plane_name)
    InputLineView planeName;
    @BindView(R.id.add_plane_input_plane_email)
    InputLineView email;
    @BindView(R.id.add_plane_input_plane_address)
    InputLineView address;
    @BindView(R.id.add_plane_head_image)
    ImageView head_image;
    @BindView(R.id.add_plane_sumbit)
    Button sumbit;

    public AddPlaneFragment() {
    }


    public static AddPlaneFragment newInstance() {
        return new AddPlaneFragment();
    }


    @Override
    public void initUI() {
        planeName.setTitleView("飞机名:");
        email.setTitleView("邮箱:");
        address.setTitleView("地址");
        sumbit.setText("提交");
    }

    @Override
    public void initData() {

    }

    @Override
    public void addListeners() {
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPlaneSharePage();
            }
        });
    }

    private void toPlaneSharePage() {
        replaceFragment(R.id.main_container, ShareFragment.newInstance());
    }

    @Override
    public void onEventMessage(EventMessage em) {

    }

    @Override
    public int inflaterRootView() {
        return R.layout.add_new_plane_fragement;
    }
}
