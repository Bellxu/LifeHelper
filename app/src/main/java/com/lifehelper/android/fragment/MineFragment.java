package com.lifehelper.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lifehelper.android.R;
import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.databinding.FragmentCookBinding;
import com.lifehelper.android.databinding.FragmentMineBinding;

public class MineFragment extends BaseFragment {

    private FragmentMineBinding mViewBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentMineBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }
}
