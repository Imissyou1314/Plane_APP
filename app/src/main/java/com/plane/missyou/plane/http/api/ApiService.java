package com.plane.missyou.plane.http.api;

import com.plane.missyou.plane.entity.Message;
import com.plane.missyou.plane.entity.Plane;
import com.plane.missyou.plane.entity.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by MissC on 2017/5/5.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("miss/plane/{id}")
    Observable<ApiResponse<Plane>> getDatas(@Field("id") int id);

    // Restful API
    @GET("message/{id}")
    Observable<ApiResponse<Message>> getMessageById(@Path("id") int id);

    @POST("user/create")
    Observable<ApiResponse<User>> createUser(@Body User user);

    @Multipart
    @POST("message/upload")
    Observable<ApiResponse> upImage( );
}
