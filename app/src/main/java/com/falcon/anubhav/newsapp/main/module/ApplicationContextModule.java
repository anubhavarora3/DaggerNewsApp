package com.falcon.anubhav.newsapp.main.module;

import android.content.Context;

import com.falcon.anubhav.newsapp.main.scope.NewsApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by anubhav on 15/03/18.
 */

@Module
public class ApplicationContextModule {

    private Context context;

    public ApplicationContextModule(Context context) {
        this.context = context;
    }

    @NewsApplicationScope
    @Provides
    public Context getContext() {
        return context.getApplicationContext();
    }
}
