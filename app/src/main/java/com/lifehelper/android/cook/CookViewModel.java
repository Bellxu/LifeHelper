package com.lifehelper.android.cook;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lifehelper.android.bean.ResultBean;
import com.lifehelper.android.bean.SearchCookBean;
import com.lifehelper.android.bean.SearchCookResultBean;
import com.lifehelper.android.net.ApiService;
import com.lifehelper.android.net.UrlProvider;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CookViewModel extends ViewModel {


    private MutableLiveData<List<SearchCookBean>> cooks;
    private MutableLiveData<List<SearchCookBean>> cooksDefault;

    public LiveData<List<SearchCookBean>> getCooks(String keyword, int num, int start) {
        if (cooks == null) {
            cooks = new MutableLiveData<>();
            searchCook(keyword, num, start);
        }
        return cooks;
    }

    public LiveData<List<SearchCookBean>> getCooksByClass(int num, int start) {
        if (cooksDefault == null) {
            cooksDefault = new MutableLiveData<>();
            searchCookByClass(num, start);
        }
        return cooksDefault;
    }


    public void searchCook(String keyword, int num, int start) {
        Log.i("xsk--", "searchCook: ");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.CaiPuBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.searchCook(keyword, num, start, UrlProvider.appkey).enqueue(new Callback<ResultBean<SearchCookResultBean>>() {
            @Override
            public void onResponse(Call<ResultBean<SearchCookResultBean>> call, Response<ResultBean<SearchCookResultBean>> response) {
                Log.i("xsk--", "onResponse: ");
                ResultBean<SearchCookResultBean> body = response.body();
                List<SearchCookBean> list = body.getResult().getResult().getList();
                cooks.setValue(list);
            }

            @Override
            public void onFailure(Call<ResultBean<SearchCookResultBean>> call, Throwable t) {

            }
        });

    }

    public void searchCookByClass(int num, int start) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.CaiPuBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.searchCookByClass(302, num, start, UrlProvider.appkey).enqueue(new Callback<ResultBean<SearchCookResultBean>>() {
            @Override
            public void onResponse(Call<ResultBean<SearchCookResultBean>> call, Response<ResultBean<SearchCookResultBean>> response) {
                ResultBean<SearchCookResultBean> body = response.body();
                List<SearchCookBean> list = body.getResult().getResult().getList();
                cooksDefault.setValue(list);
            }

            @Override
            public void onFailure(Call<ResultBean<SearchCookResultBean>> call, Throwable t) {

            }
        });

    }
}
