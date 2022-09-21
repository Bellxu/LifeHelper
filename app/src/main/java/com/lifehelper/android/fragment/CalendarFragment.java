package com.lifehelper.android.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lifehelper.android.R;
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewBinding = FragmentCalendarBinding.inflate(getLayoutInflater());
        return mViewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.miui10Calendar.setCheckMode(CheckModel.SINGLE_DEFAULT_CHECKED);
        //可以画点
//        InnerPainter innerPainter = (InnerPainter) mViewBinding.miui10Calendar.getCalendarPainter();
//        innerPainter.setPointList(pointList);

        mViewBinding.miui10Calendar.setOnCalendarChangedListener(new OnCalendarChangedListener() {
            @Override
            public void onCalendarChange(BaseCalendar baseCalendar, int year, int month, LocalDate localDate, DateChangeBehavior dateChangeBehavior) {
                mViewBinding.tvResult.setText(year + "年" + month + "月" + "   当前页面选中 " + localDate);
//                Log.d(TAG, "   当前页面选中 " + localDate);
//                Log.d(TAG, "   dateChangeBehavior " + dateChangeBehavior);
//
//                Log.e(TAG, "baseCalendar::" + baseCalendar);
                if (localDate != null) {
                    CalendarDate calendarDate = CalendarUtil.getCalendarDate(localDate);
                    Lunar lunar = calendarDate.lunar;
                    mViewBinding.tvData.setText(localDate.toString("yyyy年MM月dd日"));
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
    }
}
