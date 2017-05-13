package com.plane.missyou.plane.http.cache;

import com.plane.missyou.plane.entity.Plane;
import com.plane.missyou.plane.http.api.ApiResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.EvictProvider;
import io.rx_cache2.LifeCache;

/**
 * Created by MissC on 2017/5/5.
 */

public interface CacheProvider {

    @LifeCache(duration = 5, timeUnit = TimeUnit.MINUTES)
    Observable<ApiResponse<Plane>> getDatas(Observable<ApiResponse<Plane>> oRepos,
                                            EvictProvider evictProvider);

}
