package com.falcon.anubhav.newsapp.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhav on 14/03/18.
 */

public class SourceList {

    @SerializedName("status")
    private String status;
    @SerializedName("sources")
    private List<Sources> sources = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Sources> getSources() {
        return sources;
    }

    public void setSources(List<Sources> sources) {
        this.sources = sources;
    }
}
