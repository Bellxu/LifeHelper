package com.lifehelper.android.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CookDao {

    @Query("select * from cook")
    List<Cook> getAll();

    @Query("SELECT * FROM cook WHERE uid == :uid")
    List<Cook> queryCooksByUid(int uid);

    @Query("SELECT * FROM cook WHERE cookId == :cookId")
    List<Cook> queryCooksByCookId(int cookId);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
        //遇到重复的插入则替换
    void insertCook(Cook... cooks);


    @Delete()
    void delete(Cook cook);

}
