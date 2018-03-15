package com.falcon.anubhav.newsapp.main.main;

import com.falcon.anubhav.newsapp.main.model.Sources;

import java.util.List;

/**
 * Created by anubhav on 14/03/18.
 */

public class MainPresenter implements IMainPresenter, IMainInteractor.OnFinishedListener{

    private IMainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenter(IMainView mainView, MainInteractor mainInteractor) {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            mainView.showProgressBar();
        }
        mainInteractor.fetchItems(this);
    }

    @Override
    public void onSuccess(List<Sources> sources, String message) {
        if (mainView != null) {
            mainView.hideProgressBar();
            mainView.setItem(sources, message);
        }
    }

    @Override
    public void onFailure(String message) {
        mainView.setErrorMessage(message);
    }
}
