package com.lifehelper.android.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.UserManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lifehelper.android.R;
import com.lifehelper.android.activiry.CookCollectActivity;
import com.lifehelper.android.activiry.HomeActivity;
import com.lifehelper.android.activiry.SettingActivity;
import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.dao.User;
import com.lifehelper.android.dao.UserDao;
import com.lifehelper.android.databinding.FragmentMineBinding;
import com.lifehelper.android.mine.MineAdapter;
import com.lifehelper.android.bean.mine.MineBean;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends BaseFragment {

    private FragmentMineBinding mViewBinding;
    private List<MineBean> data = new ArrayList<>();
    private MineAdapter mineAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentMineBinding.inflate(getLayoutInflater());
        initData();
        return mViewBinding.getRoot();
    }

    private void initData() {
        data.add(new MineBean("天气", R.mipmap.ic_weather_selected));
        data.add(new MineBean("菜谱", R.mipmap.ic_cookbook_selected));
        data.add(new MineBean("日历", R.mipmap.ic_calendar_selected));
        data.add(new MineBean("菜谱收藏", R.mipmap.ic_collect_selected));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.tcUserName.setText(UserInfoManger.getInstance().getUser().nickName);
        mViewBinding.tcUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                // 设置主题的构造方法
                // AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomDialog);
                LayoutInflater inflater = getActivity().getLayoutInflater();
                View view = inflater.inflate(R.layout.fragment_dialog, null);
                EditText editText = view.findViewById(R.id.edit_text);
                builder.setView(view);
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    private String newName;

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Editable text = editText.getText();

                        newName = text.toString();
                        if (TextUtils.isEmpty(newName)) {
                            ToastUtils.showToast(getActivity(), "用户名为空");
                            return;
                        }
                        changeUserName(newName);

                    }
                });
                builder.create().show();
                // Do Someting,eg: TextView tv = view.findViewById(R.id.edit_text);
            }
        });
        mViewBinding.imageSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingActivity.startActivity(getActivity());
            }
        });
        mViewBinding.boomRv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mineAdapter = new MineAdapter(R.layout.item_mine);
        mineAdapter.addData(data);
        mViewBinding.boomRv.setAdapter(mineAdapter);
        mineAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                MineBean mineBean = mineAdapter.getData().get(position);
                HomeActivity activity = (HomeActivity) getActivity();
                if (activity == null) {
                    return;
                }
                switch (mineBean.title) {
                    case "天气":
                        activity.switchTab(0);
                        break;
                    case "菜谱":
                        activity.switchTab(1);
                        break;
                    case "日历":
                        activity.switchTab(2);
                        break;
                    case "菜谱收藏":
                        CookCollectActivity.startActivity(activity);
                        break;
                }
            }
        });
    }

    private void changeUserName(String newName) {
        mViewBinding.tcUserName.setText(newName);
        User user = UserInfoManger.getInstance().getUser();
        user.nickName = newName;
        UserInfoManger.getInstance().setUser(user);
        DbManger.getInstance().getAppDatabase().userDao().updateUser(user);
        ToastUtils.showToast(getActivity(), "修改成功");
    }
}
