package com.lifehelper.android.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lifehelper.android.R;
import com.lifehelper.android.bean.weather.Weather;
import com.lifehelper.android.bean.weather.WeatherDailyBean;
import com.lifehelper.android.bean.weather.WeatherRealTimeBean;
import com.lifehelper.android.dao.User;
import com.lifehelper.android.databinding.FragmentWeatherBinding;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.util.TimeUtils;
import com.lifehelper.android.weather.Sky;
import com.lifehelper.android.weather.SkyProvider;
import com.lifehelper.android.weather.WeatherViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherFragment extends BaseFragment {


    private FragmentWeatherBinding binding;
    private WeatherViewModel viewModel;

    public FragmentWeatherBinding getBinding() {
        return binding;
    }

    public void setBinding(FragmentWeatherBinding binding) {
        this.binding = binding;
    }

    public WeatherViewModel getViewModel() {
        return viewModel;
    }

    public void setViewModel(WeatherViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentWeatherBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(WeatherViewModel.class);
        User user = UserInfoManger.getInstance().getUser();
        //获取用户的地址信息设置经纬度和地址名
        if (user.place != null) {
            viewModel.locationLat = user.place.lat;
            viewModel.locationLng = user.place.lng;
            viewModel.placeName = user.place.name;
        }
        //设置监听
        viewModel.weatherLiveData.observe(getViewLifecycleOwner(), new Observer<Weather>() {
            @Override
            public void onChanged(Weather weather) {
                //设置页面信息
                showWeatherInfo(weather);
                binding.swipeRefresh.finishRefresh();
            }
        });
        refreshWeather();

        binding.swipeRefresh.setOnRefreshListener(refreshLayout -> {
            refreshWeather();
        });
        binding.swipeRefresh.setEnableLoadMore(false);
        binding.includeNow.navBtn.setOnClickListener(v -> {
            binding.drawerLayout.openDrawer(GravityCompat.START);
        });
        binding.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(drawerView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }

    public void refreshWeather() {
        viewModel.refreshWeather(viewModel.locationLng, viewModel.locationLat);
    }

    private void showWeatherInfo(Weather weather) {
        WeatherRealTimeBean.ResultDTO.RealtimeDTO realtime = weather.weatherRealTimeBean.getResult().getRealtime();
        WeatherDailyBean.ResultDTO.DailyDTO daily = weather.weatherDailyBean.getResult().getDaily();
        binding.includeNow.placeName.setText(viewModel.placeName);

        // 填充now.xml布局中数据
        String currentTempText = realtime.getTemperature() + "℃";
        binding.includeNow.currentTemp.setText(currentTempText);
        String info = SkyProvider.getInstance().getSky(realtime.getSkycon()).getInfo();
        binding.includeNow.currentSky.setText(info);
        String currentPM25Text = "空气指数" + realtime.getAir_quality().getAqi().getChn();
        binding.includeNow.currentAQI.setText(currentPM25Text);
        binding.includeNow.nowLayout.setBackgroundResource(SkyProvider.getInstance().getSky(realtime.getSkycon()).getBg());
        // 填充forecast.xml布局中的数据
        binding.includeForecast.forecastLayout.removeAllViews();
        int size = daily.getSkycon().size();
        for (int i = 0; i < size; i++) {
            WeatherDailyBean.ResultDTO.DailyDTO.SkyconDTO skycon = daily.getSkycon().get(i);
            WeatherDailyBean.ResultDTO.DailyDTO.TemperatureDTO temperature = daily.getTemperature().get(i);
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.forecast_item, binding.includeForecast.forecastLayout, false);
            TextView dateInfo = view.findViewById(R.id.dateInfo);
            ImageView skyIcon = view.findViewById(R.id.skyIcon);
            TextView skyInfo = view.findViewById(R.id.skyInfo);
            TextView temperatureInfo = view.findViewById(R.id.temperatureInfo);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            try {
                dateInfo.setText(simpleDateFormat.format(simpleDateFormat.parse(skycon.getDate())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Sky sky = SkyProvider.getInstance().getSky(realtime.getSkycon());
            skyIcon.setImageResource(sky.getIcon());
            skyInfo.setText(sky.getInfo());
            String s = temperature.getMin() + "~" + temperature.getMax();
            temperatureInfo.setText(s);
            binding.includeForecast.forecastLayout.addView(view);
        }
        // 填充life_index.xml布局中的数据
        WeatherDailyBean.ResultDTO.DailyDTO.LifeIndexDTO lifeIndex = daily.getLife_index();
        binding.lifeIndex.coldRiskText.setText(lifeIndex.getColdRisk().get(0).getDesc());
        binding.lifeIndex.dressingText.setText(lifeIndex.getDressing().get(0).getDesc());
        binding.lifeIndex.ultravioletText.setText(lifeIndex.getUltraviolet().get(0).getDesc());
        binding.lifeIndex.carWashingText.setText(lifeIndex.getCarWashing().get(0).getDesc());
        binding.weatherLayout.setVisibility(View.VISIBLE);
    }

}
