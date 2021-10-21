package com.coding.exam.directory.repository;

import android.app.Application;

import com.coding.exam.directory.data.dao.Profile;
import com.coding.exam.directory.data.dao.ProfileDao;
import com.coding.exam.directory.data.db.AppDatabase;

import androidx.lifecycle.LiveData;

/**
 * Class repository to query profile details from database.
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class ProfileDetailsRepository {

    private ProfileDao profileDao;

    public ProfileDetailsRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        profileDao = db.profileDao();
    }

    public LiveData<Profile> geTProfileDetails(int id) {
        return profileDao.findProfileById(id);
    }
}
