package com.lifehelper.android.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true) //可设置主键自增长
    public int uid;

    @ColumnInfo
    public String userName;

    @ColumnInfo
    public String nickName;

    @ColumnInfo
    public String password;
}
