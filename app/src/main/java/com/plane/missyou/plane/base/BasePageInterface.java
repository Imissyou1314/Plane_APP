package com.plane.missyou.plane.base;

import android.app.Activity;

import com.plane.missyou.plane.entity.EventMessage;

/**
 * Created by MissC on 2017/5/5.
 */

public interface BasePageInterface {
    public static final int NONE = -1;

    public static final int REQUEST_CODE = 0X01;

    public static final int RESULT_OK = Activity.RESULT_OK;

    public static final int RESULT_CANCELED = Activity.RESULT_CANCELED;


    public static final String KEY_ID = "key_id";

    public static final String KEY_TITLE = "key_title";

    public static final String KEY_URL = "key_url";

    public static final String KEY_SERIALIZABLE = "key_serializable";

    public static final String KEY_OBJECT = "key_object";

    public static final String KEY_FRAGMENT = "key_fragment";


    public abstract void initUI();
    public abstract void initData();
    public abstract void addListeners();

    public abstract void onEventMessage(EventMessage em);
}
