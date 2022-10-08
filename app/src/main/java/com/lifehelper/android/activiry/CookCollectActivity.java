package com.lifehelper.android.activiry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lifehelper.android.R;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.cook.CookCollectAdapter;
import com.lifehelper.android.cook.CookSearchAdapter;
import com.lifehelper.android.dao.Cook;
import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.databinding.ActivityCookCollectBinding;
import com.lifehelper.android.databinding.ActivityCookDetailBinding;
import com.lifehelper.android.user.UserInfoManger;

import java.util.List;

public class CookCollectActivity extends AppCompatActivity {

    private ActivityCookCollectBinding binding;
    private CookCollectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCookCollectBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initView();
        initData();
    }

    private void initView() {
        adapter = new CookCollectAdapter(R.layout.item_search_cook);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                Cook data = (Cook) adapter.getData().get(position);
                CookDetailActivity.startActivity(CookCollectActivity.this, data.cookId);
            }
        });
    }

    private void initData() {
        int uid = UserInfoManger.getInstance().getUser().uid;
        List<Cook> cooks = DbManger.getInstance().getAppDatabase().cookDao().queryCooksByUid(uid);
        adapter.setList(cooks);
    }


    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, CookCollectActivity.class);
        activity.startActivity(intent);
    }
}