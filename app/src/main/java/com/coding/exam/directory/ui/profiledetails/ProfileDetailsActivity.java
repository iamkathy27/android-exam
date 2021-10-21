package com.coding.exam.directory.ui.profiledetails;

import android.content.Intent;
import android.os.Bundle;

import com.coding.exam.directory.R;
import com.coding.exam.directory.databinding.ProfileDetailsBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

/**
 * Screen that displays the details of the selected user/profile
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class ProfileDetailsActivity extends AppCompatActivity {

    private ProfileDetailsBinding profileDetailsBinding;
    private ProfileDetailsViewModel profileDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileDetailsViewModel = new ViewModelProvider(this).get(ProfileDetailsViewModel.class);
        profileDetailsBinding = DataBindingUtil.setContentView(this, R.layout.profile_details);
        setContentView(profileDetailsBinding.getRoot());

        initialize();
    }

    private void initialize() {
        Intent myIntent = getIntent();
        int intValue = myIntent.getIntExtra("profileId", 0);
        profileDetailsViewModel.getProfileDetails(intValue).observe(this, profile -> profileDetailsBinding.setProfileDetails(profile));
        profileDetailsBinding.back.setOnClickListener(v -> onBackPressed());
    }
}
