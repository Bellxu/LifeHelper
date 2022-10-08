package com.lifehelper.android.place;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lifehelper.android.R;
import com.lifehelper.android.bean.weather.WeatherPlaceBean;

public class PlaceAdapter extends BaseQuickAdapter<WeatherPlaceBean.PlacesDTO, BaseViewHolder> {
    public PlaceAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, WeatherPlaceBean.PlacesDTO weatherPlaceBean) {
            baseViewHolder.setText(R.id.placeName,weatherPlaceBean.getName()).setText(R.id.placeAddress,weatherPlaceBean.getFormatted_address());
    }
}
