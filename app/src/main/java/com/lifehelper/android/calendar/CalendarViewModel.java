package com.lifehelper.android.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lifehelper.android.bean.calendar.RollResultBean;
import com.lifehelper.android.bean.calendar.TodayBean;
import com.lifehelper.android.net.ApiService;
import com.lifehelper.android.net.KeyProvider;
import com.lifehelper.android.net.UrlProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalendarViewModel extends ViewModel {


    public MutableLiveData<TodayBean> todayLiveData=new MutableLiveData<>();


    public void getToday(String date) {
        getTodayInfo(date);
    }

    //获取今天的万年历信息
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
                todayLiveData.setValue(data);
            }

            @Override
            public void onFailure(Call<RollResultBean<TodayBean>> call, Throwable t) {

            }
        });
    }


}
