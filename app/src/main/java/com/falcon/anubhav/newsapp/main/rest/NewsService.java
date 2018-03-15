package com.falcon.anubhav.newsapp.main.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anubhav on 14/03/18.
 */

public class NewsService {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://newsapi.org/v2/";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
