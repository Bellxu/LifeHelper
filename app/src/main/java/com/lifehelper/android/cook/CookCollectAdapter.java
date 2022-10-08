package com.lifehelper.android.cook;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lifehelper.android.R;
import com.lifehelper.android.bean.cook.SearchCookBean;
import com.lifehelper.android.dao.Cook;

public class CookCollectAdapter extends BaseQuickAdapter<Cook, BaseViewHolder> {

    public CookCollectAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, Cook cook) {
        baseViewHolder.setText(R.id.tv_title, cook.name);

        GlideUrl glideUrl = new GlideUrl(cook.pic, new LazyHeaders.Builder()
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit / 537.36(KHTML, like Gecko) Chrome  47.0.2526.106 Safari / 537.36")
                .build());

        Glide.with(getContext()).load(glideUrl).into((ImageView) baseViewHolder.getView(R.id.image));

    }
}
