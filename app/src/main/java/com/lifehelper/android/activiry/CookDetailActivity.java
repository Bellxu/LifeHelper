package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.lifehelper.android.R;
import com.lifehelper.android.bean.SearchCookBean;
import com.lifehelper.android.cook.CookDetailAdapter;
import com.lifehelper.android.cook.CookSearchAdapter;
import com.lifehelper.android.cook.CookViewModel;
import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.databinding.ActivityCookDetailBinding;

public class CookDetailActivity extends AppCompatActivity {

    private ActivityCookDetailBinding binding;
    private CookViewModel model;
    private int cookId;
    private CookDetailAdapter adapter;


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
        binding.imageCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectCooKId();
            }
        });
        model.getCook(cookId).observe(this, new Observer<SearchCookBean>() {
            @Override
            public void onChanged(SearchCookBean searchCookBean) {
                Glide.with(CookDetailActivity.this).load(searchCookBean.getPic()).into(binding.imageCover);
                binding.tvTitle.setText(searchCookBean.getName());
                binding.tvRequire.setText("所需人数：" + searchCookBean.getPeoplenum() + "\n"
                        + "所需准备时间:" + searchCookBean.getPreparetime() + "\n" + "所需烹饪时间:" + searchCookBean.getCookingtime());
                binding.tvContent.setText(searchCookBean.getContent().replace("<br />", "\n"));
                binding.tvMaterialContent.setText(getMaterialContent(searchCookBean));
                adapter.setList(searchCookBean.getProcess());
            }
        });
    }

    private void collectCooKId() {
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