package com.falcon.anubhav.newsapp.main.module;

import com.falcon.anubhav.newsapp.main.rest.NewsApiInterface;
import com.falcon.anubhav.newsapp.main.scope.NewsApplicationScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anubhav on 14/03/18.
 */

@Module
public class NewsApiModule {

    private String baseURL = "https://newsapi.org/v2/";

    public NewsApiModule(String baseURL) {
        this.baseURL = baseURL;
    }

    @NewsApplicationScope
    @Provides
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public NewsApiInterface newsApiInterface(Retrofit retrofit) {
        return retrofit.create(NewsApiInterface.class);
    }
}
