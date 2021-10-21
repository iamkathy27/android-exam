package com.coding.exam.directory.data.db;

import android.content.Context;

import com.coding.exam.directory.data.dao.Profile;
import com.coding.exam.directory.data.dao.ProfileDao;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Class to initialize and create Room database
 *
 * @author by katherine.sobejano on 10/21/2021.
 */
@Database(entities={Profile.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProfileDao profileDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "profile_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
