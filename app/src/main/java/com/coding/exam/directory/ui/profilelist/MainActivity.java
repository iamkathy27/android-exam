package com.coding.exam.directory.ui.profilelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.coding.exam.directory.R;
import com.coding.exam.directory.data.dao.Profile;
import com.coding.exam.directory.databinding.ActivityMainBinding;

import java.util.List;

/**
 * Main screen that displays the list of users
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private ProfileViewModel profileViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(activityMainBinding.getRoot());

        initialize();
    }

    private void initialize() {
        profileViewModel.getListProfile();

        if (!profileViewModel.isNetworkAvailable(this)) {
            Toast.makeText(this, getString(R.string.no_connection), Toast.LENGTH_LONG).show();
        }

        profileViewModel.getAllProfile().observe(this, (Observer<List<Profile>>) profile -> {
            if (profile != null) {
                ProfileListAdapter myRecyclerViewAdapter = new ProfileListAdapter(profile, this);
                activityMainBinding.listRecyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
                activityMainBinding.setMyAdapter(myRecyclerViewAdapter);
            }
        });
    }
}
