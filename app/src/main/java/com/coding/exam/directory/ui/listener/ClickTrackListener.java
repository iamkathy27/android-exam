package com.coding.exam.directory.ui.listener;

import com.coding.exam.directory.data.dao.Profile;

/**
 * Listener to display the details of a specific user
 *
 * @author by katherine.sobejano on 10/21/2021.
 */
public interface ClickTrackListener {
    void openProfileDetails(Profile profile);
}
