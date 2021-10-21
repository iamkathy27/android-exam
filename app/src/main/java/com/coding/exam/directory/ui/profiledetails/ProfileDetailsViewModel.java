package com.coding.exam.directory.ui.profiledetails;

import android.app.Application;

import com.coding.exam.directory.data.dao.Profile;
import com.coding.exam.directory.repository.ProfileDetailsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * ViewModel class that handles the specific user's information
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class ProfileDetailsViewModel extends AndroidViewModel {

    private ProfileDetailsRepository profileDetailsRepository;

    public ProfileDetailsViewModel(@NonNull Application application) {
        super(application);
        profileDetailsRepository = new ProfileDetailsRepository(application);
    }

    public LiveData<Profile> getProfileDetails(int id) {
        return profileDetailsRepository.geTProfileDetails(id);
    }
}
