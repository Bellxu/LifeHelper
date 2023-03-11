package com.lifehelper.android.activiry;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lifehelper.android.R;
import com.lifehelper.android.fragment.CalendarFragment;
import com.lifehelper.android.fragment.CookBookFragment;
import com.lifehelper.android.fragment.MineFragment;
import com.lifehelper.android.fragment.WeatherFragment;

public class HomeActivity extends BaseActivity {

    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private DemoCollectionAdapter demoCollectionAdapter;

    private static final String[] tab_title = new String[]{"天气", "菜谱", "日历", "我的"};
    private static final int[] tab_icon = new int[]{R.drawable.ic_weather, R.drawable.ic_cookbook, R.drawable.ic_calendar, R.drawable.ic_mine};

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);
        viewPager.setUserInputEnabled(false);
        demoCollectionAdapter = new DemoCollectionAdapter(this);
        viewPager.setAdapter(demoCollectionAdapter);
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(tab_title[position]);
                tab.setIcon(tab_icon[position]);
            }
        }).attach();
    }

    public static class DemoCollectionAdapter extends FragmentStateAdapter {

        public DemoCollectionAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = new WeatherFragment();
                    break;
                case 1:
                    fragment = new CookBookFragment();
                    break;
                case 2:
                    fragment = new CalendarFragment();
                    break;
                case 3:
                    fragment = new MineFragment();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }
            return fragment;
        }

        @Override
        public int getItemCount() {
            return 4;
        }


    }

    public void switchTab(int index) {
        viewPager.setCurrentItem(index);
    }

}