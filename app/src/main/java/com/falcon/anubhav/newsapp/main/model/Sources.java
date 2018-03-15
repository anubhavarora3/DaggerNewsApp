package com.falcon.anubhav.newsapp.main.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhav on 14/03/18.
 */

public class Sources {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
