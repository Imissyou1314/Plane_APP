package com.plane.missyou.plane.view;

import android.os.Bundle;

import com.plane.missyou.plane.base.BaseFragment;
import com.plane.missyou.plane.entity.EventMessage;


/**
 * Created by MissC on 2017/4/4.
 */

public class PlaneMessageFragment extends BaseFragment {

    private static final String PLAEN_MESSAGE_TYPE = "PLAEN_MESSAGE_TYPE";
    private int mType;

    public static PlaneMessageFragment newInstance(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt(PLAEN_MESSAGE_TYPE, type);
        PlaneMessageFragment fragment = new PlaneMessageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void initUI() {
        mType = getArguments().getInt(PLAEN_MESSAGE_TYPE);
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
        return 0;
    }
}
