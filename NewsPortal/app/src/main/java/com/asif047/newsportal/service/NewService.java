package com.asif047.newsportal.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 1/5/2019.
 */

public class NewService {

    private Retrofit retrofit = null;

    public NewsAPI getAPI() {
        String BASE_URL = "https://newsapi.org/";

        if(retrofit == null) {
            retrofit = new Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        }

        return retrofit.create(NewsAPI.class);
    }

}
