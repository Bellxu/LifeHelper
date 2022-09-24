package com.lifehelper.android.dao;

import android.content.Context;

import androidx.room.Room;

public class DbManger {
    private AppDatabase mAppDatabase;

    private static class Holder {
        private static DbManger INSTANCE = new DbManger();
    }

    public static DbManger getInstance() {
        return Holder.INSTANCE;
    }

    public void init(Context context) {
        mAppDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "android_room_life_help.db")
                .allowMainThreadQueries()
//                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .build();


    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }
}
