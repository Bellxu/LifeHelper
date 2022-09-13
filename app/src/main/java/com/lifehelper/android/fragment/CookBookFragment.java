package com.lifehelper.android.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.lifehelper.android.R;
import com.lifehelper.android.bean.SearchCookBean;
import com.lifehelper.android.cook.CookSearchAdapter;
import com.lifehelper.android.cook.CookViewModel;
import com.lifehelper.android.databinding.ActivityLoginBinding;
import com.lifehelper.android.databinding.FragmentCollectionObjectBinding;
import com.lifehelper.android.databinding.FragmentCooktBinding;
import com.lifehelper.android.util.ToastUtils;

import java.util.List;

public class CookBookFragment extends BaseFragment {
    private final MutableLiveData<List<SearchCookBean>> cooksLiveData = new MutableLiveData<List<SearchCookBean>>();
    private CookViewModel model;
    private FragmentCooktBinding mViewBinding;
    private CookSearchAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewBinding = FragmentCooktBinding.inflate(getLayoutInflater());

        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        adapter = new CookSearchAdapter(R.layout.search_cook);
        model = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(CookViewModel.class);
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
                String keyword = s.toString();
                if (!keyword.isEmpty()) {
                    searchKeyword(keyword);
                }
            }
        });

        model.getCooksByClass(10, 0).observe(getViewLifecycleOwner(), new Observer<List<SearchCookBean>>() {
            @Override
            public void onChanged(List<SearchCookBean> searchCookBeans) {
                adapter.setList(searchCookBeans);
//                adapter.addData(searchCookBeans);
                Log.i("xsk--", "getCooksByClass onChanged: " + Thread.currentThread().getName());
            }
        });
    }

    private void searchKeyword(String keyword) {
        model.getCooks(keyword, 10, 0).observe(getViewLifecycleOwner(), new Observer<List<SearchCookBean>>() {
            @Override
            public void onChanged(List<SearchCookBean> searchCookBeans) {
                adapter.setList(searchCookBeans);
                Log.i("xsk--", "searchKeyword onChanged: " + Thread.currentThread().getName());
            }
        });


    }
}
