package com.falcon.anubhav.newsapp.main.main;

import com.falcon.anubhav.newsapp.main.model.Sources;

import java.util.List;

/**
 * Created by anubhav on 14/03/18.
 */

public interface IMainInteractor {

    interface OnFinishedListener {
        void onSuccess(List<Sources> sources, String message);

        void onFailure(String message);
    }

    void fetchItems(OnFinishedListener finishedListener);
}
