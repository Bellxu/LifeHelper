package com.lifehelper.android.place;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lifehelper.android.bean.weather.WeatherPlaceBean;
import com.lifehelper.android.net.ApiService;
import com.lifehelper.android.net.UrlProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceViewModel extends ViewModel {
    public MutableLiveData<WeatherPlaceBean> placeLiveData = new MutableLiveData<>();


    public void searPlace(String keywords) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.weatherBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        //通过关键字搜索地址信息
        apiService.searchPlaces(keywords).enqueue(new Callback<WeatherPlaceBean>() {
            @Override
            public void onResponse(Call<WeatherPlaceBean> call, Response<WeatherPlaceBean> response) {
                placeLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<WeatherPlaceBean> call, Throwable t) {
                placeLiveData.setValue(null);
            }
        });
    }
}
