package com.plane.missyou.plane.view.fragment;

import android.animation.Animator;
import android.widget.ImageView;

import com.plane.missyou.plane.R;
import com.plane.missyou.plane.base.BaseFragment;
import com.plane.missyou.plane.entity.EventMessage;

import butterknife.BindView;


/**
 * Created by MissC on 2017/4/4.
 */

public class ShareFragment extends BaseFragment {


    @BindView(R.id.share_plane_image)
    ImageView animateView;


    public static BaseFragment newInstance() {
        return new ShareFragment();
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addListeners() {
        animateView.animate()
                .setStartDelay(500)
                .setDuration(1000)
                .translationY(-5000)
                .withLayer().setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                toTimeLinePage();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void toTimeLinePage() {
        replaceFragment(R.id.main_container, TimeLineFragment.newInstance());
    }

    @Override
    public void onEventMessage(EventMessage em) {

    }

    @Override
    public int inflaterRootView() {
        return R.layout.share_fragment;
    }

}
