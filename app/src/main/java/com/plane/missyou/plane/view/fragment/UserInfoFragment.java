package com.plane.missyou.plane.view.fragment;

import com.plane.missyou.plane.R;
import com.plane.missyou.plane.base.BaseFragment;
import com.plane.missyou.plane.entity.EventMessage;


/**
 * Created by MissC on 2017/4/4.
 */

public class UserInfoFragment extends BaseFragment {

    public static BaseFragment newInstance() {
        return new UserInfoFragment();
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addListeners() {

    }

    @Override
    public void onEventMessage(EventMessage em) {

    }

    @Override
    public int inflaterRootView() {
        return R.layout.user_info_fragment;
    }

}
