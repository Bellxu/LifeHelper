package com.lifehelper.android.weather;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lifehelper.android.bean.cook.ResultBean;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.bean.cook.SearchCookListBean;
import com.lifehelper.android.bean.cook.SearchCookResultBean;
import com.lifehelper.android.bean.weather.Weather;
import com.lifehelper.android.bean.weather.WeatherDailyBean;
import com.lifehelper.android.bean.weather.WeatherRealTimeBean;
import com.lifehelper.android.net.ApiService;
import com.lifehelper.android.net.KeyProvider;
import com.lifehelper.android.net.UrlProvider;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherViewModel extends ViewModel {
    public String placeName;
    public String locationLng = "121.212288";
    public String locationLat = "31.404875";


    public MutableLiveData<Weather> weatherLiveData = new MutableLiveData<>();


    public void refreshWeather(String locationLng, String locationLat) {
        if (weatherLiveData == null) {
            weatherLiveData = new MutableLiveData<>();
        }
        getWeather(locationLng, locationLat);
    }

    private void getWeather(String locationLng, String locationLat) {
        Weather weather = new Weather();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.weatherBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        //获取实时天气
        apiService.getRealtimeWeather(locationLng, locationLat).enqueue(new Callback<WeatherRealTimeBean>() {
            @Override
            public void onResponse(Call<WeatherRealTimeBean> call, Response<WeatherRealTimeBean> response) {
                weather.weatherRealTimeBean = response.body();
                //获取天级别的天气
                apiService.getDailyWeather(locationLng, locationLat).enqueue(new Callback<WeatherDailyBean>() {
                    @Override
                    public void onResponse(Call<WeatherDailyBean> call, Response<WeatherDailyBean> response) {
                        weather.weatherDailyBean = response.body();
                        weatherLiveData.setValue(weather);

                    }
                    @Override
                    public void onFailure(Call<WeatherDailyBean> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<WeatherRealTimeBean> call, Throwable t) {

            }
        });

    }


}
