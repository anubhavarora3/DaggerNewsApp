package com.falcon.anubhav.newsapp.main.main;

import com.falcon.anubhav.newsapp.main.model.Sources;

import java.util.List;

/**
 * Created by anubhav on 14/03/18.
 */

public interface IMainView {

    void showProgressBar();
    void hideProgressBar();
    void setItem(List<Sources> sources, String message);
    void setErrorMessage(String message);
}
