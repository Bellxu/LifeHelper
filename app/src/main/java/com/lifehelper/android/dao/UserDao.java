package com.lifehelper.android.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from user")
    List<User> getAll();

    @Query("select * from user where uid in (:uIds) ")
    List<User> getUserListByIds(int[] uIds);

    @Query("SELECT * FROM user WHERE userName == :name")
    List<User> queryUsersBytName(String name);

    @Query("SELECT * FROM user WHERE uid == :uid")
    List<User> queryUsersBytUid(String uid);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
        //遇到重复的插入则替换
    void insertUser(User... users);

    @Update(onConflict = OnConflictStrategy.REPLACE)
        //遇到重复的插入则替换
    void updateUser(User... users);

    @Delete
    void delete(User user);

}
