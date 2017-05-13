package com.plane.missyou.plane.view;

/**
 * Created by MissC on 2017/5/9.
 */

public interface BaseView {

    void showProgress();

    void onCompleted();

    void onSuccess();

    void onError( String errorStr);
}
