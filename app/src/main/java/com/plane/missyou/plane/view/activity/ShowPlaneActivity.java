package com.plane.missyou.plane.view.activity;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.plane.missyou.plane.R;
import com.plane.missyou.plane.base.BaseActivity;
import com.plane.missyou.plane.entity.EventMessage;

import butterknife.BindView;

/**
 * Created by MissC on 2017/5/11.
 */

public class ShowPlaneActivity extends BaseActivity {

    @BindView(R.id.show_plane_webView)
    WebView mWebView;

    @Override
    public void initUI() {
        WebSettings mWebSetting = mWebView.getSettings();
        mWebSetting.setLoadWithOverviewMode(true);
        mWebSetting.setJavaScriptEnabled(true);
        mWebSetting.setAllowFileAccess(true);
        mWebSetting.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.loadUrl("https://paperplanes.world/");
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
        return R.layout.show_plane_activity;
    }
}
