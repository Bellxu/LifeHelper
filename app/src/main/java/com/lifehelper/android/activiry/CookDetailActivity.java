package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.lifehelper.android.R;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.cook.CookDetailAdapter;
import com.lifehelper.android.cook.CookViewModel;
import com.lifehelper.android.dao.Cook;
import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.databinding.ActivityCookDetailBinding;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.util.ToastUtils;

import java.util.List;

public class CookDetailActivity extends AppCompatActivity {

    private ActivityCookDetailBinding binding;
    private CookViewModel model;
    private int cookId;
    private CookDetailAdapter adapter;
    private SearchCookBean mBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCookDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        cookId = getIntent().getIntExtra("cookId", 0);
        model = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(CookViewModel.class);
        setContentView(view);
        adapter = new CookDetailAdapter(R.layout.item_detial_cook);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.imageBack.setOnClickListener(v -> onBackPressed());
        binding.imageCollect.setSelected(checkCollect());
        binding.imageCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imageCollect.setSelected(!binding.imageCollect.isSelected());

                collectCooKId(binding.imageCollect.isSelected());
            }
        });
        //????????????????????????UI
        model.cook.observe(this, new Observer<SearchCookBean>() {
            @Override
            public void onChanged(SearchCookBean searchCookBean) {
                if (searchCookBean == null) {
                    showError(true);
                } else {
                    showError(false);
                    mBean = searchCookBean;
                    Glide.with(CookDetailActivity.this).load(searchCookBean.getPic()).into(binding.imageCover);
                    binding.tvTitle.setText(searchCookBean.getName());
                    binding.tvRequire.setText("???????????????" + searchCookBean.getPeoplenum() + "\n"
                            + "??????????????????:" + searchCookBean.getPreparetime() + "\n" + "??????????????????:" + searchCookBean.getCookingtime());
                    binding.tvContent.setText(searchCookBean.getContent().replace("<br />", "\n"));
                    binding.tvMaterialContent.setText(getMaterialContent(searchCookBean));
                    adapter.setList(searchCookBean.getProcess());
                }

            }
        });
        //??????Id????????????
        model.getCook(cookId);
    }

    private boolean checkCollect() {
        List<Cook> cooks = DbManger.getInstance().getAppDatabase().cookDao().queryCooksByCookId(cookId);
        return cooks != null && !cooks.isEmpty();
    }

    private void showError(boolean show) {
        if (show) {
            binding.errorLayout.getRoot().setVisibility(View.VISIBLE);
            binding.contentLayout.setVisibility(View.GONE);
        } else {
            binding.errorLayout.getRoot().setVisibility(View.GONE);
            binding.contentLayout.setVisibility(View.VISIBLE);
        }
    }


    private void collectCooKId(boolean selected) {
        if (!UserInfoManger.getInstance().checkLogin() || mBean == null) {
            return;
        }
        Cook cook = new Cook();
        cook.cookId = cookId;
        cook.name = mBean.getName();
        cook.pic = mBean.getPic();
        cook.uid = UserInfoManger.getInstance().getUser().uid;
        if (selected) {
            DbManger.getInstance().getAppDatabase().cookDao().insertCook(cook);
            ToastUtils.showToast(this, "????????????");
        } else {
            DbManger.getInstance().getAppDatabase().cookDao().delete(cook);
            ToastUtils.showToast(this, "????????????");
        }

    }

    private String getMaterialContent(SearchCookBean searchCookBean) {
        StringBuilder stringBuilder = new StringBuilder();
        for (SearchCookBean.MaterialDTO materialDTO : searchCookBean.getMaterial()) {
            stringBuilder.append(materialDTO.getMname());
            stringBuilder.append("------------");
            stringBuilder.append(materialDTO.getAmount());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void startActivity(Activity activity, int id) {
        Intent intent = new Intent(activity, CookDetailActivity.class);
        intent.putExtra("cookId", id);
        activity.startActivity(intent);
    }


}