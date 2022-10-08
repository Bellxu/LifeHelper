package com.lifehelper.android.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class Place {
    @ColumnInfo
    public String name;
    @ColumnInfo
    public String lng;
    @ColumnInfo
    public String lat;

}
