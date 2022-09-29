package com.lifehelper.android.net;

import com.lifehelper.android.bean.calendar.RollResultBean;
import com.lifehelper.android.bean.calendar.TodayBean;
import com.lifehelper.android.bean.cook.ResultBean;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.bean.cook.SearchCookResultBean;
import com.lifehelper.android.bean.weather.WeatherDailyBean;
import com.lifehelper.android.bean.weather.WeatherPlaceBean;
import com.lifehelper.android.bean.weather.WeatherRealTimeBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search")
    Call<ResultBean<SearchCookResultBean>> searchCook(@Query("keyword") String keyword, @Query("num") int num, @Query("start") int start, @Query("appkey") String appkey);

    @GET("byclass")
    Call<ResultBean<SearchCookResultBean>> searchCookByClass(@Query("classid") int classId, @Query("num") int num, @Query("start") int start, @Query("appkey") String appkey);

    @GET("detail")
    Call<ResultBean<SearchCookBean>> searchCookById(@Query("id") int cookId, @Query("appkey") String appkey);

    @GET("holiday/single/{date}")
    Call<RollResultBean<TodayBean>> getTodayInfo(@Path("date") String date, @Query("app_id") String appId, @Query("app_secret") String appSecret, @Query("ignoreHoliday") boolean ignoreHoliday);

    @GET("v2/place?token=" + KeyProvider.WEATHER_APP_KEY + "&lang=zh_CN")
    Call<WeatherPlaceBean> searchPlaces(@Query("query") String place);

    @GET("v2.5/" + KeyProvider.WEATHER_APP_KEY + "/{lng},{lat}/realtime.json")
    Call<WeatherRealTimeBean> getRealtimeWeather(@Path("lng") String lng, @Path("lat") String lat);

    @GET("v2.5/" + KeyProvider.WEATHER_APP_KEY + "/{lng},{lat}/daily.json")
    Call<WeatherDailyBean> getDailyWeather(@Path("lng") String lng, @Path("lat") String lat);

}
