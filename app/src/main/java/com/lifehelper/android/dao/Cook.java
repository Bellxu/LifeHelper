package com.lifehelper.android.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cook {

    @PrimaryKey
    public int cookId;

    @ColumnInfo
    public int uid;

    @ColumnInfo
    public String pic;

    @ColumnInfo
    public String name;
}
