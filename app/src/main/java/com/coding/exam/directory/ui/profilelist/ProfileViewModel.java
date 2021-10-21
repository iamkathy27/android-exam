package com.coding.exam.directory.ui.profilelist;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.coding.exam.directory.data.dao.Profile;
import com.coding.exam.directory.data.service.ApiClient;
import com.coding.exam.directory.repository.ProfileListRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ViewModel class that handles all data
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class ProfileViewModel extends AndroidViewModel {

    private ProfileListRepository profileListRepository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        profileListRepository = new ProfileListRepository(application);
    }

    public LiveData<List<Profile>> getAllProfile() {
        return profileListRepository.getAllProfile();
    }

    public void getListProfile() {

        Call<List<Profile>> call = ApiClient.getInstance().getMyApi().getAllProfile();

        call.enqueue(new Callback<List<Profile>>() {
            @Override
            public void onResponse(Call<List<Profile>> call, Response<List<Profile>> response) {
                profileListRepository.insert(response.body());
            }

            @Override
            public void onFailure(Call<List<Profile>> call, Throwable t) {
            }
        });
    }

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
