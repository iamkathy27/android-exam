package com.coding.exam.directory.data.service;

import com.coding.exam.directory.data.dao.Profile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Interface for GET method to request result.
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public interface ApiRequest {

    @GET("94b11052-dff1-4bb0-acb4-16ca477a1d87")
    Call<List<Profile>> getAllProfile();
}
