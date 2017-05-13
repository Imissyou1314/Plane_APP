package com.plane.missyou.plane.view.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.plane.missyou.plane.R;
import com.plane.missyou.plane.adpater.ViewHolderRecyclerAdapter;
import com.plane.missyou.plane.adpater.holder.ViewHolder;
import com.plane.missyou.plane.entity.User;
import com.plane.missyou.plane.utils.LogUtils;
import com.plane.missyou.plane.utils.ToastUtils;
import com.plane.missyou.plane.view.BaseView;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by MissC on 2017/4/4.
 */

public class HomeFragment extends Fragment implements  LocationSource, AMapLocationListener, BaseView {

    MapView mMapView;
    @BindView(R.id.message_list)
    RecyclerView messageListView;

    LocationSource.OnLocationChangedListener mListener;
    AMapLocationClient mlocationClient;
    AMapLocationClientOption mLocationOption;
    AMap mMap;

    private ViewHolderRecyclerAdapter<User> planeAdpater;
    private List<User> userList = new ArrayList<User>();

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);

        initUI(view, savedInstanceState);
        initData();
        addListeners();

        return view;
    }

    public void initUI(View view, @Nullable Bundle savedInstanceState) {
        messageListView.setLayoutManager(new LinearLayoutManager(getContext()));
        messageListView.setHasFixedSize(true);
        planeAdpater = new ViewHolderRecyclerAdapter<User>(getContext(), userList) {
            @Override
            public View buildConvertView(LayoutInflater layoutInflater, int viewType) {
                return inflate(R.layout.item_home_user);
            };

            @Override
            public void bindViewDatas(ViewHolder holder, User user, int position) {
                holder.setText(R.id.item_home_user_name, user.getName());
                holder.setImageResource(R.id.item_home_user_image,
                        R.drawable.ic_account_circle_black_24dp);
            }
        };
        messageListView.setAdapter(planeAdpater);

        mMapView = (MapView) view.findViewById(R.id.home_map);
        mMapView.onCreate(savedInstanceState);
        if (null == mMap) {
            mMap = mMapView.getMap();
        }

        // 设置定位监听
        new RxPermissions(getActivity())
                .request(Manifest.permission_group.LOCATION)
                .subscribe(granted -> {
                    if (granted) {
                        mMap.setLocationSource(this);
                    } else {
                        ToastUtils.showToast(getContext(), "没有定位权限");
                    }
                });
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        mMap.setMyLocationEnabled(true);
        // 设置定位的类型为定位模式，有定位、跟随或地图根据面向方向旋转几种
//        mMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
    }

    public void initData() {
        User user;
        for (int i = 0; i < 10; i ++ ) {
            user = new User();
            user.setId(i + "");
            user.setUserName("miss" + i);
            userList.add(user);
        }
        planeAdpater.notifyDataSetChanged();
    }

    public void addListeners() {

    }

    @Override
    public void onDestroy() {
        LogUtils.i("onDestroy");
        super.onDestroy();
        mMapView.onDestroy();
        if(null != mlocationClient){
            mlocationClient.onDestroy();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        if (mlocationClient == null) {
            //初始化定位
            mlocationClient = new AMapLocationClient(getContext());
            //初始化定位参数
            mLocationOption = new AMapLocationClientOption();
            //设置定位回调监听
            mlocationClient.setLocationListener(this);
            //设置为高精度定位模式
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位参数
            mlocationClient.setLocationOption(mLocationOption);
            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
            // 在定位结束后，在合适的生命周期调用onDestroy()方法
            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
            mlocationClient.startLocation();//启动定位
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (mListener != null && amapLocation != null) {
            if (amapLocation != null && amapLocation.getErrorCode() == 0) {
                LogUtils.i(amapLocation.getLatitude() + "");
                LogUtils.i(amapLocation.getLongitude() + "");
                mListener.onLocationChanged(amapLocation);// 显示系统小蓝点
            } else {
                String errText = "定位失败," + amapLocation.getErrorCode()+ ": " + amapLocation.getErrorInfo();
                LogUtils.e(errText);
            }
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onError(String errorStr) {

    }
}
