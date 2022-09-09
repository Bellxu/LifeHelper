package com.lifehelper.android;

import android.app.Application;

import androidx.room.Room;

import com.lifehelper.android.dao.AppDatabase;
import com.lifehelper.android.dao.DbManger;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbManger.getInstance().init(this);
    }


}
