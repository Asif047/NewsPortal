package com.asif047.newsportal.service;

import com.asif047.newsportal.model.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by admin on 1/5/2019.
 */

public interface NewsAPI {

    @GET("v2/everything")
    Call<News> getNews(@Query("q") String type, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);

}
