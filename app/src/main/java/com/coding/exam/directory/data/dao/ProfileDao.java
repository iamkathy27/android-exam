package com.coding.exam.directory.data.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Class to insert and query PROFILE from Room database.
 *
 * @author by katherine.sobejano on 10/21/2021.
 */
@Dao
public interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAllProfile(List<Profile> profile_list);

    @Query("SELECT * FROM PROFILE_LIST")
    public LiveData<List<Profile>> getAllMProfile();

    @Query("SELECT * FROM PROFILE_LIST WHERE id = :profileId LIMIT 1")
    public LiveData<Profile> findProfileById(int profileId);
}
