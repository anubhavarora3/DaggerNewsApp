package com.falcon.anubhav.newsapp.main.app;

import android.app.Activity;
import android.app.Application;

import com.falcon.anubhav.newsapp.main.component.DaggerNewsComponent;
import com.falcon.anubhav.newsapp.main.component.NewsComponent;
import com.falcon.anubhav.newsapp.main.module.ApplicationContextModule;
import com.falcon.anubhav.newsapp.main.module.NewsApiModule;

/**
 * Created by anubhav on 14/03/18.
 */

public class NewsApplication extends Application {

    private NewsComponent newsComponent;
    private static final String BASE_URL = "https://newsapi.org/v2/";
    
    public static NewsApplication get(Activity activity){
        return (NewsApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        newsComponent = DaggerNewsComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .newsApiModule(new NewsApiModule(BASE_URL))
                .build();

    }

    public NewsComponent getNewsComponent() {
        return newsComponent;
    }
}
