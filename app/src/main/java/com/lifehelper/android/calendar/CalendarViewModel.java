package com.lifehelper.android.calendar;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lifehelper.android.bean.calendar.RollResultBean;
import com.lifehelper.android.bean.calendar.TodayBean;
import com.lifehelper.android.bean.cook.ResultBean;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.bean.cook.SearchCookResultBean;
import com.lifehelper.android.net.ApiService;
import com.lifehelper.android.net.KeyProvider;
import com.lifehelper.android.net.UrlProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalendarViewModel extends ViewModel {


    private MutableLiveData<TodayBean> today;


    public LiveData<TodayBean> getToday(String date) {
        if (today == null) {
            today = new MutableLiveData<>();
        }
        getTodayInfo(date);
        return today;
    }

    private void getTodayInfo(String date) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.calendarBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getTodayInfo(date, KeyProvider.ROLL_APP_ID, KeyProvider.ROLL_APP_SECRET, false).enqueue(new Callback<RollResultBean<TodayBean>>() {
            @Override
            public void onResponse(Call<RollResultBean<TodayBean>> call, Response<RollResultBean<TodayBean>> response) {
                RollResultBean<TodayBean> body = response.body();
                TodayBean data = body.getData();
                today.setValue(data);
            }

            @Override
            public void onFailure(Call<RollResultBean<TodayBean>> call, Throwable t) {

            }
        });
    }


}
