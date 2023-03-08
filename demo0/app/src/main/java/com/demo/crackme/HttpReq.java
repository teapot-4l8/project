package com.demo.crackme;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpReq {
    // 写函数名即可
    // 向/api/v1/post 发送POST请求  name=xx&pwd=xxx
    @POST("/api/v1/post")
    @FormUrlEncoded
    Call<ResponseBody> postLogin(@Field("name") String userName, @Field("pwd") String password);

    // ->/api/v2/xxx?age=999
//    @GET("/api/v2/xxx")
//    Call<ResponseBody> getInfo(@Query("age") String age);

    // 向/post/users 发送POST请求 {name:xxxx,age:123}
    @POST("/post/users")
    Call<ResponseBody> postLoginJson(@Body RequestBody body);

    @GET("/index")
    Call<ResponseBody> getIndex(@Query("age") String age);
}
