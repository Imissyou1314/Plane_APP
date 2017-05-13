package com.plane.missyou.plane;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.plane.missyou.plane.constant.Constant;
import com.plane.missyou.plane.http.HttpManager;

import me.shaohui.shareutil.ShareConfig;
import me.shaohui.shareutil.ShareManager;

/**
 * Created by MissC on 2017/5/6.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 缓存Application 引用
        HttpManager.init(this);

        initLogin();
    }

    private void initLogin() {
        ShareConfig config = ShareConfig.instance()
                .qqId(Constant.QQ_ID)
                .wxId(Constant.WX_ID)
                .weiboId(Constant.WEIBO_ID)
                // 下面两个，如果不需要登录功能，可不填写
                .weiboRedirectUrl(Constant.REDIRECT_URL)
                .wxSecret(Constant.WX_ID);
        ShareManager.init(config);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
