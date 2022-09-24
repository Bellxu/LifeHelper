package com.lifehelper.android.net;

import com.lifehelper.android.bean.ResultBean;
import com.lifehelper.android.bean.SearchCookBean;
import com.lifehelper.android.bean.SearchCookResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search")
    Call<ResultBean<SearchCookResultBean>> searchCook(@Query("keyword") String keyword, @Query("num") int num, @Query("start") int start, @Query("appkey") String appkey);

    @GET("byclass")
    Call<ResultBean<SearchCookResultBean>> searchCookByClass(@Query("classid") int classId, @Query("num") int num, @Query("start") int start, @Query("appkey") String appkey);

    @GET("detail")
    Call<ResultBean<SearchCookBean>> searchCookById(@Query("id") int cookId, @Query("appkey") String appkey);
}
