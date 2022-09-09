package com.lifehelper.android.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from user")
    List<User> getAll();

    @Query("select * from user where uid in (:uIds) ")
    List<User> getUserListByIds(int[] uIds);

    @Query("SELECT * FROM user WHERE userName == :name")
    List<User> queryUsersBytName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        //遇到重复的插入则替换
    void insertUser(User... users);

    @Delete
    void delete(User user);

}