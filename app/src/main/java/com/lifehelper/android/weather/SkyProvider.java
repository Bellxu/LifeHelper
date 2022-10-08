package com.lifehelper.android.weather;

import com.lifehelper.android.R;
import com.lifehelper.android.user.UserInfoManger;

import java.util.HashMap;
import java.util.Map;

public class SkyProvider {
    Map<String, Sky> Skys = new HashMap<>();

    public SkyProvider() {
        initSkys();
    }

    private void initSkys() {
        Skys.put("CLEAR_DAY", new Sky("晴", R.drawable.ic_clear_day, R.drawable.bg_clear_day));
        Skys.put("CLEAR_NIGHT", new Sky("晴", R.drawable.ic_clear_night, R.drawable.bg_clear_night));
        Skys.put("PARTLY_CLOUDY_DAY", new Sky("多云", R.drawable.ic_partly_cloud_day, R.drawable.bg_partly_cloudy_day));
        Skys.put("PARTLY_CLOUDY_NIGHT", new Sky("多云", R.drawable.ic_partly_cloud_night, R.drawable.bg_partly_cloudy_night));
        Skys.put("CLOUDY", new Sky("阴", R.drawable.ic_cloudy, R.drawable.bg_cloudy));
        Skys.put("WIND", new Sky("大风", R.drawable.ic_cloudy, R.drawable.bg_wind));
        Skys.put("LIGHT_RAIN", new Sky("小雨", R.drawable.ic_light_rain, R.drawable.bg_rain));
        Skys.put("MODERATE_RAIN", new Sky("中雨", R.drawable.ic_moderate_rain, R.drawable.bg_rain));
        Skys.put("HEAVY_RAIN", new Sky("大雨", R.drawable.ic_heavy_rain, R.drawable.bg_rain));
        Skys.put("STORM_RAIN", new Sky("暴雨", R.drawable.ic_storm_rain, R.drawable.bg_rain));
        Skys.put("THUNDER_SHOWER", new Sky("雷阵雨", R.drawable.ic_thunder_shower, R.drawable.bg_rain));
        Skys.put("SLEET", new Sky("雨夹雪", R.drawable.ic_sleet, R.drawable.bg_rain));
        Skys.put("LIGHT_SNOW", new Sky("小雪", R.drawable.ic_light_snow, R.drawable.bg_snow));
        Skys.put("MODERATE_SNOW", new Sky("中雪", R.drawable.ic_moderate_snow, R.drawable.bg_snow));
        Skys.put("HEAVY_SNOW", new Sky("大雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow));
        Skys.put("STORM_SNOW", new Sky("暴雪", R.drawable.ic_heavy_snow, R.drawable.bg_snow));
        Skys.put("HAIL", new Sky("冰雹", R.drawable.ic_hail, R.drawable.bg_snow));
        Skys.put("LIGHT_HAZE", new Sky("轻度雾霾", R.drawable.ic_light_haze, R.drawable.bg_fog));
        Skys.put("MODERATE_HAZE", new Sky("中度雾霾", R.drawable.ic_moderate_haze, R.drawable.bg_fog));
        Skys.put("HEAVY_HAZE", new Sky("重度雾霾", R.drawable.ic_heavy_haze, R.drawable.bg_fog));
        Skys.put("FOG", new Sky("雾", R.drawable.ic_fog, R.drawable.bg_fog));
        Skys.put("DUST", new Sky("浮尘", R.drawable.ic_fog, R.drawable.bg_fog));
    }

    private static class Holder {
        private static SkyProvider INSTANCE = new SkyProvider();
    }

    public static SkyProvider getInstance() {
        return SkyProvider.Holder.INSTANCE;
    }

    public Sky getSky(String skycon){
        return Skys.get(skycon);
    }
}
