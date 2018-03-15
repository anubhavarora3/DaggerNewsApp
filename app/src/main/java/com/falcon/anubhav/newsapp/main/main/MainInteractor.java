package com.falcon.anubhav.newsapp.main.main;

import android.content.Context;

import com.falcon.anubhav.newsapp.main.app.NewsApplication;
import com.falcon.anubhav.newsapp.main.model.SourceList;
import com.falcon.anubhav.newsapp.main.model.Sources;
import com.falcon.anubhav.newsapp.main.rest.NewsApiInterface;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by anubhav on 14/03/18.
 */

public class MainInteractor implements IMainInteractor{

    private final String apiKey = "f926bb3ad1d0472f97651eeb3df8967e";
    private List<Sources> sources;

    @Inject
    Context context;

    @Inject
    NewsApiInterface newsApiInterface;

    public MainInteractor() {
        ((NewsApplication) context).getNewsComponent().inject(this);
    }

    @Override
    public void fetchItems(final OnFinishedListener finishedListener) {

        Call<SourceList> call = newsApiInterface.getSourceList(apiKey);
        call.enqueue(new Callback<SourceList>() {
            @Override
            public void onResponse(Call<SourceList> call, Response<SourceList> response) {
                if (response.isSuccessful()) {
                    sources = response.body().getSources();
                    finishedListener.onSuccess(sources, response.message().toString());
                } else {
                    finishedListener.onFailure(response.message().toString());
                }
            }

            @Override
            public void onFailure(Call<SourceList> call, Throwable t) {
                finishedListener.onFailure(t.getMessage());
            }
        });
    }
}
