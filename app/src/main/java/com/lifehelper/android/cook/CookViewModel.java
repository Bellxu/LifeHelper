package com.lifehelper.android.cook;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lifehelper.android.bean.cook.ResultBean;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.bean.cook.SearchCookListBean;
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

public class CookViewModel extends ViewModel {


    public MutableLiveData<SearchCookListBean> cooks = new MutableLiveData<>();
    public MutableLiveData<SearchCookBean> cook = new MutableLiveData<>();

    public void getCooks(String keyword, int num, int start) {
        if (cooks == null) {
            cooks = new MutableLiveData<>();
        }
        searchCooks(keyword, num, start);
    }

    public void getCook(int id) {
        if (cook == null) {
            cook = new MutableLiveData<>();
        }
        searchCook(id);
    }

    private void searchCook(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.cookBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.searchCookById(id, KeyProvider.COOK_APP_KEY).enqueue(new Callback<ResultBean<SearchCookBean>>() {
            @Override
            public void onResponse(Call<ResultBean<SearchCookBean>> call, Response<ResultBean<SearchCookBean>> response) {
                Log.i("xsk--", "onResponse: ");
                ResultBean<SearchCookBean> body = response.body();
                SearchCookBean result = body.getResult().getResult();
                cook.setValue(result);
            }

            @Override
            public void onFailure(Call<ResultBean<SearchCookBean>> call, Throwable t) {
                cook.setValue(null);
            }
        });
    }

    public void getCooksByClass(int num, int start) {
        if (cook == null) {
            cook = new MutableLiveData<>();
        }
        searchCookByClass(num, start);
    }


    public void searchCooks(String keyword, int num, int start) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.cookBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.searchCook(keyword, num, start, KeyProvider.COOK_APP_KEY).enqueue(new Callback<ResultBean<SearchCookResultBean>>() {
            @Override
            public void onResponse(Call<ResultBean<SearchCookResultBean>> call, Response<ResultBean<SearchCookResultBean>> response) {
                ResultBean<SearchCookResultBean> body = response.body();
                SearchCookListBean searchCookListBean = new SearchCookListBean();
                if (start > 0) {
                    searchCookListBean.setRequestType(1);
                } else {
                    searchCookListBean.setRequestType(0);
                }
                List<SearchCookBean> list = body.getResult().getResult().getList();
                searchCookListBean.setList(list);
                cooks.setValue(searchCookListBean);
            }

            @Override
            public void onFailure(Call<ResultBean<SearchCookResultBean>> call, Throwable t) {
                cooks.setValue(null);

            }
        });

    }

    public void searchCookByClass(int num, int start) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlProvider.cookBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        //302为推荐菜谱ID
        apiService.searchCookByClass(302, num, start, KeyProvider.COOK_APP_KEY).enqueue(new Callback<ResultBean<SearchCookResultBean>>() {
            @Override
            public void onResponse(Call<ResultBean<SearchCookResultBean>> call, Response<ResultBean<SearchCookResultBean>> response) {
                ResultBean<SearchCookResultBean> body = response.body();
                SearchCookListBean searchCookListBean = new SearchCookListBean();
                if (start > 0) {
                    searchCookListBean.setRequestType(1);
                } else {
                    searchCookListBean.setRequestType(0);
                }
                List<SearchCookBean> list = body.getResult().getResult().getList();
                searchCookListBean.setList(list);
                cooks.setValue(searchCookListBean);
            }

            @Override
            public void onFailure(Call<ResultBean<SearchCookResultBean>> call, Throwable t) {
                cooks.setValue(null);
            }
        });

    }
}
