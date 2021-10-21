package com.coding.exam.directory.data.service;

import com.coding.exam.directory.utils.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that holds Retrofit instance
 *
 * @author katherine.sobejano on 10/21/2021.
 */
public class ApiClient {

    private static ApiClient instance = null;
    private static ApiRequest mHttpApi;
    static final String BASE_URL = Constant.BASE_URL;

    private static Retrofit retrofit = null;

    private ApiClient() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(120, TimeUnit.SECONDS)
                .connectTimeout(120, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        mHttpApi = retrofit.create(ApiRequest.class);
    }

    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public ApiRequest getMyApi() {
        return mHttpApi;
    }

}
