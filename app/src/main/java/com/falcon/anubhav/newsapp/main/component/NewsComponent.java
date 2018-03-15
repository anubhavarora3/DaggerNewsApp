package com.falcon.anubhav.newsapp.main.component;

import com.falcon.anubhav.newsapp.main.main.MainActivity;
import com.falcon.anubhav.newsapp.main.main.MainInteractor;
import com.falcon.anubhav.newsapp.main.module.ApplicationContextModule;
import com.falcon.anubhav.newsapp.main.module.NewsApiModule;
import com.falcon.anubhav.newsapp.main.scope.NewsApplicationScope;

import dagger.Component;

/**
 * Created by anubhav on 14/03/18.
 */

@NewsApplicationScope
@Component(modules = {NewsApiModule.class,
        ApplicationContextModule.class})

public interface NewsComponent {
    void inject(MainActivity mainActivity);
    void inject(MainInteractor mainInteractor);
}
