package com.lifehelper.android.place;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lifehelper.android.bean.weather.WeatherPlaceBean;
import com.lifehelper.android.net.ApiService;
import com.lifehelper.android.net.UrlProvider;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
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
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().build();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {

            }
        });

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
