package com.plane.missyou.plane.http;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.litesuits.android.log.Log;
import com.plane.missyou.plane.constant.Constant;
import com.plane.missyou.plane.entity.Plane;
import com.plane.missyou.plane.http.api.ApiResponse;
import com.plane.missyou.plane.http.api.ApiService;
import com.plane.missyou.plane.http.cache.CacheProvider;
import com.plane.missyou.plane.http.exception.ApiException;
import com.plane.missyou.plane.http.parser.GsonTSpeaker;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.internal.RxCache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MissC on 2017/5/5.
 */

public class HttpManager {
    public static final String TAG=HttpManager.class.getSimpleName();
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit mRetrofit;
    private ApiService mApiService;
    private final CacheProvider cacheProvider;
    private static Context mContext;
    private volatile static HttpManager instance;

    private HttpManager() {
        HttpLoggingInterceptor.Level level= HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("HttpManager",message);
            }
        });
        loggingInterceptor.setLevel(level);
        //拦截请求和响应日志并输出，其实有很多封装好的日志拦截插件，大家也可以根据个人喜好选择。
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor);

        OkHttpClient okHttpClient = builder.build();

        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .client(okHttpClient)
                .build();

        cacheProvider = new RxCache.Builder()
                .persistence(mContext.getFilesDir(), new GsonTSpeaker())
                .using(CacheProvider.class);

        mApiService = mRetrofit.create(ApiService.class);
    }

    public static HttpManager getInstance() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager();
                }
            }
        }
        return instance;
    }

    public static void init(Context context){
        mContext=context;
    }

    private <T> void toSubscribe(Observable<ApiResponse<T>> o, Observer<T> s) {
        o.subscribeOn(Schedulers.io())
                .map(new Function<ApiResponse<T>, T>() {
                    @Override
                    public T apply(@NonNull ApiResponse<T> response) throws Exception {
                        if (response.isResultStatus()) {
                            throw new ApiException(response.getResultCode(),
                                    response.getResultError());
                        } else {
                            return response.getResultData();
                        }
                    }
                })
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    public void getDatasWithCache(Observer<Plane> subscriber, int id, boolean update) {
        toSubscribe(cacheProvider.getDatas(mApiService.getDatas(id),new EvictProvider(update)), subscriber);
    }
    public void getDatasNoCache(Observer<Plane> subscriber, int id) {
        toSubscribe(mApiService.getDatas(id), subscriber);
    }

}
