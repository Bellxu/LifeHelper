package com.lifehelper.android.mine;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lifehelper.android.R;

public class MineAdapter extends BaseQuickAdapter<MineBean, BaseViewHolder> {
    public MineAdapter(int layoutResId) {
        super(layoutResId);

    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, MineBean item) {
        baseViewHolder.setText(R.id.tv_title, item.title).setImageResource(R.id.image, item.ImageResId);

    }
}
