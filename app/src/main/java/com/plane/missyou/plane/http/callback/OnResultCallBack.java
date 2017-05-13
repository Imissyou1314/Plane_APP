package com.plane.missyou.plane.http.callback;

/**
 * Created by MissC on 2017/5/5.
 */

public interface OnResultCallBack<T> {

    void onSuccess(T t);

    void onError(int code, String errorMsg);
}
