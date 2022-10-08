package com.lifehelper.android.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lifehelper.android.R;
import com.lifehelper.android.activiry.HomeActivity;
import com.lifehelper.android.bean.weather.WeatherPlaceBean;
import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.dao.Place;
import com.lifehelper.android.dao.User;
import com.lifehelper.android.databinding.FragmentPlaceBinding;
import com.lifehelper.android.place.PlaceAdapter;
import com.lifehelper.android.place.PlaceViewModel;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.weather.WeatherViewModel;

import java.util.List;

public class PlaceFragment extends BaseFragment {

    private FragmentPlaceBinding binding;
    private PlaceViewModel viewModel;
    private PlaceAdapter placeAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlaceBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(PlaceViewModel.class);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        placeAdapter = new PlaceAdapter(R.layout.place_item);
        binding.recyclerView.setAdapter(placeAdapter);
        binding.searchPlaceEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = s.toString();
                if (!text.isEmpty()) {
                    viewModel.searPlace(text);
                } else {
                    binding.bgImageView.setVisibility(View.VISIBLE);
                    binding.recyclerView.setVisibility(View.GONE);
                }

            }
        });

        placeAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                User user = UserInfoManger.getInstance().getUser();
                WeatherPlaceBean.PlacesDTO place = (WeatherPlaceBean.PlacesDTO) adapter.getData().get(position);
                Place place1 = new Place();
                String placeName = place.getName();
                place1.name = placeName;
                String lat = place.getLocation().getLat();
                place1.lat = lat;
                String lng = place.getLocation().getLng();
                place1.lng = lng;
                user.place = place1;
                DbManger.getInstance().getAppDatabase().userDao().updateUser(user);
                UserInfoManger.getInstance().setUser(user);
                for (Fragment fragment : getActivity().getSupportFragmentManager().getFragments()) {
                    if (fragment instanceof WeatherFragment) {
                        WeatherFragment weatherFragment = (WeatherFragment) fragment;
                        weatherFragment.getViewModel().placeName = placeName;
                        weatherFragment.getViewModel().locationLat = lat;
                        weatherFragment.getViewModel().locationLng = lng;
                        weatherFragment.refreshWeather();
                        weatherFragment.getBinding().drawerLayout.close();
                    }
                }

            }

        });

        viewModel.placeLiveData.observe(getViewLifecycleOwner(), new Observer<WeatherPlaceBean>() {
            @Override
            public void onChanged(WeatherPlaceBean weatherPlaceBean) {
                if (weatherPlaceBean != null && weatherPlaceBean.getPlaces() != null) {
                    List<WeatherPlaceBean.PlacesDTO> places = weatherPlaceBean.getPlaces();
                    placeAdapter.setList(places);
                    binding.bgImageView.setVisibility(View.GONE);
                    binding.recyclerView.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}
