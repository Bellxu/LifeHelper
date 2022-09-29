package com.lifehelper.android.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.lifehelper.android.R;
import com.lifehelper.android.activiry.CookDetailActivity;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.bean.cook.SearchCookListBean;
import com.lifehelper.android.cook.CookSearchAdapter;
import com.lifehelper.android.cook.CookViewModel;
import com.lifehelper.android.databinding.FragmentCookBinding;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

public class CookBookFragment extends BaseFragment {
    private final MutableLiveData<List<SearchCookBean>> cooksLiveData = new MutableLiveData<List<SearchCookBean>>();
    private CookViewModel model;
    private FragmentCookBinding mViewBinding;
    private CookSearchAdapter adapter;
    private String keyword;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewBinding = FragmentCookBinding.inflate(getLayoutInflater());

        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(CookViewModel.class);
        initLiveDataObserver();
        adapter = new CookSearchAdapter(R.layout.item_search_cook);
        mViewBinding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        mViewBinding.recyclerView.setAdapter(adapter);
        mViewBinding.searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i("xsk--", "afterTextChanged: " + s.toString());
                keyword = s.toString();
                searchKeyword();
            }
        });
        recommend();
        adapter.setOnItemClickListener((adapter, view1, position) -> {
            SearchCookBean data = (SearchCookBean) adapter.getData().get(position);
            CookDetailActivity.startActivity(getActivity(), data.getId());
        });
        mViewBinding.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refresh();
            }
        });
        mViewBinding.refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadMore();
            }
        });
    }

    private void initLiveDataObserver() {
        model.cooks.observe(getViewLifecycleOwner(), new Observer<SearchCookListBean>() {
            @Override
            public void onChanged(SearchCookListBean searchCookListBean) {
                if (searchCookListBean.getRequestType() == 0) {
                    adapter.setList(searchCookListBean.getList());
                    mViewBinding.refreshLayout.finishRefresh();

                } else {
                    adapter.addData(searchCookListBean.getList());
                    mViewBinding.refreshLayout.finishLoadMore();

                }
            }
        });
    }

    private void refresh() {
        if (keyword == null || keyword.isEmpty()) {
            recommend();
        } else {
            searchKeyword();
        }
    }


    private void loadMore() {
        int size = adapter.getData().size();
        if (keyword == null || keyword.isEmpty()) {
            recommend(size);
        } else {
            searchKeyword(size);
        }

    }

    private void recommend() {
        model.getCooksByClass(10, 0);
    }

    private void recommend(int start) {
        model.getCooksByClass(10, start);
    }

    private void searchKeyword() {
        if (keyword == null || keyword.isEmpty()) {
            return;
        }
        model.getCooks(keyword, 10, 0);
    }

    private void searchKeyword(int start) {
        if (keyword == null || keyword.isEmpty()) {
            return;
        }
        model.getCooks(keyword, 10, start);

    }

}
