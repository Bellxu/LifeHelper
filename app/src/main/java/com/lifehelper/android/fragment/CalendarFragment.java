package com.lifehelper.android.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.lifehelper.android.R;
import com.lifehelper.android.bean.calendar.TodayBean;
import com.lifehelper.android.calendar.CalendarViewModel;
import com.lifehelper.android.cook.CookViewModel;
import com.lifehelper.android.databinding.FragmentCalendarBinding;
import com.lifehelper.android.databinding.FragmentMineBinding;
import com.necer.calendar.BaseCalendar;
import com.necer.entity.CalendarDate;
import com.necer.entity.Lunar;
import com.necer.enumeration.CheckModel;
import com.necer.enumeration.DateChangeBehavior;
import com.necer.listener.OnCalendarChangedListener;
import com.necer.listener.OnCalendarMultipleChangedListener;
import com.necer.painter.InnerPainter;
import com.necer.utils.CalendarUtil;

import org.joda.time.LocalDate;

import java.util.List;

public class CalendarFragment extends BaseFragment {

    private FragmentCalendarBinding mViewBinding;
    private CalendarViewModel model;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentCalendarBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        model = new ViewModelProvider(getViewModelStore(), new ViewModelProvider.NewInstanceFactory()).get(CalendarViewModel.class);

        mViewBinding.miui10Calendar.setCheckMode(CheckModel.SINGLE_DEFAULT_CHECKED);
        //可以画点
//        InnerPainter innerPainter = (InnerPainter) mViewBinding.miui10Calendar.getCalendarPainter();
//        innerPainter.setPointList(pointList);

        mViewBinding.miui10Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
                mViewBinding.tvResult.setText(year + "年" + month + "月" + "   当前页面选中 " + localDate);
                if (localDate != null) {
                    CalendarDate calendarDate = CalendarUtil.getCalendarDate(localDate);
                    Lunar lunar = calendarDate.lunar;
                    mViewBinding.tvData.setText(localDate.toString("yyyy年MM月dd日"));
                    //获取今天的黄历信息
                    getToday(localDate);
                    mViewBinding.tvDesc.setText(lunar.chineseEra + lunar.animals + "年" + lunar.lunarMonthStr + lunar.lunarDayStr);
                } else {
                    mViewBinding.tvData.setText("");
                    mViewBinding.tvDesc.setText("");
                }
            }

        });
        mViewBinding.miui10Calendar.setOnCalendarMultipleChangedListener(new OnCalendarMultipleChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, List<LocalDate> currPagerCheckedList, List<LocalDate> totalCheckedList, DateChangeBehavior dateChangeBehavior) {
                mViewBinding.tvResult.setText(year + "年" + month + "月" + " 当前页面选中 " + currPagerCheckedList.size() + "个  总共选中" + totalCheckedList.size() + "个");
//                Log.d(TAG, year + "年" + month + "月");
//                Log.d(TAG, "当前页面选中：：" + currPagerCheckedList);
//                Log.d(TAG, "全部选中：：" + totalCheckedList);
            }

        });
        model.todayLiveData.observe(getViewLifecycleOwner(), new Observer<TodayBean>() {
            @Override
            public void onChanged(TodayBean todayBean) {
                if (todayBean != null) {
                    mViewBinding.tvSuit.setText("宜：" + todayBean.getSuit());
                    mViewBinding.tvAvoid.setText("忌：" + todayBean.getAvoid());
                    mViewBinding.tvSolarTerms.setText("节气：" + todayBean.getSolarTerms());
                    mViewBinding.tvSconstellation.setText("星座：" + todayBean.getConstellation());
                }
            }
        });
    }

    private void getToday(LocalDate localDate) {
        model.getToday(localDate.toString("yyyyMMdd"));
    }


}
