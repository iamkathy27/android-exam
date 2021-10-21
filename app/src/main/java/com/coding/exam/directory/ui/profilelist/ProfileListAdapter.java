package com.coding.exam.directory.ui.profilelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.coding.exam.directory.R;
import com.coding.exam.directory.data.dao.Profile;
import com.coding.exam.directory.databinding.ProfileItemBinding;
import com.coding.exam.directory.ui.profiledetails.ProfileDetailsActivity;
import com.coding.exam.directory.ui.listener.ClickTrackListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Adapter that handles and populates the list stored from database
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class ProfileListAdapter extends RecyclerView.Adapter<ProfileListAdapter.ViewHolder> implements ClickTrackListener {
    List<Profile> profileList;
    Context context;

    public ProfileListAdapter(List<Profile> profileList, Context context) {
        this.profileList = profileList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProfileItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.profile_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        holder.bind(profile);
        holder.itemRowBinding.setOnProfileDetails(this);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ProfileItemBinding itemRowBinding;

        public ViewHolder(ProfileItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.profile, obj);
            itemRowBinding.executePendingBindings();
        }
    }

    public void openProfileDetails(Profile profile){
        Intent intent = new Intent(context, ProfileDetailsActivity.class);
        intent.putExtra("profileId", profile.getId());
        context.startActivity(intent);
    }
}
