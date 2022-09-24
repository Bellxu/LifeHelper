package com.lifehelper.android.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cook {

    @PrimaryKey //可设置主键自增长
    public int cookId;

    @ColumnInfo
    public int uid;

    @ColumnInfo
    public String pic;

    @ColumnInfo
    public String name;
}
