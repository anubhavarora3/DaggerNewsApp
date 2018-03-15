package com.falcon.anubhav.newsapp.main.rest;

import com.falcon.anubhav.newsapp.main.model.SourceList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anubhav on 14/03/18.
 */

public interface NewsApiInterface {

    @GET("sources")
    Call<SourceList> getSourceList(@Query("apiKey") String apiKey);
}
