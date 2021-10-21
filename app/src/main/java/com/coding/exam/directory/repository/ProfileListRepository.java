package com.coding.exam.directory.repository;

import android.app.Application;
import android.os.AsyncTask;

import com.coding.exam.directory.data.dao.Profile;
import com.coding.exam.directory.data.dao.ProfileDao;
import com.coding.exam.directory.data.db.AppDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * Class repository to insert and query profile data from database.
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class ProfileListRepository {

    private ProfileDao mProfileDao;
    private LiveData<List<Profile>> profileList;

    public ProfileListRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mProfileDao = db.profileDao();
        profileList = mProfileDao.getAllMProfile();
    }

    public void insert(List<Profile> profile){
        new InsertAsyncTask(mProfileDao).execute(profile);
    }

    public LiveData<List<Profile>> getAllProfile(){
        return profileList;
    }

    private static class InsertAsyncTask extends AsyncTask<List<Profile>,Void,Void> {
        private ProfileDao mProfileDao;

        public InsertAsyncTask(ProfileDao movieTrackDao)
        {
            this.mProfileDao = movieTrackDao;
        }
        @Override
        protected Void doInBackground(List<Profile>... lists) {
            mProfileDao.insertAllProfile(lists[0]);
            return null;
        }
    }
}
