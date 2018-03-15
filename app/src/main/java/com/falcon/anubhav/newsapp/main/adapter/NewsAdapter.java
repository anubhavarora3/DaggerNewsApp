package com.falcon.anubhav.newsapp.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.falcon.anubhav.newsapp.R;
import com.falcon.anubhav.newsapp.main.main.MainActivity;
import com.falcon.anubhav.newsapp.main.model.Sources;

import java.util.List;

/**
 * Created by anubhav on 14/03/18.
 */

public class NewsAdapter extends RecyclerView.Adapter {

    private List<Sources> sources;

    public NewsAdapter(List<Sources> sources) {
        this.sources = sources;
    }

    public NewsAdapter(MainActivity mainActivity) {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NewsViewHolder) holder).onBind(position);
    }

    @Override
    public int getItemCount() {
        return sources.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName, txtUrl;

        public NewsViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtUrl = itemView.findViewById(R.id.txt_url);
        }

        public void onBind(int position) {
            Sources source = sources.get(position);
            txtName.setText(source.getName());
            txtUrl.setText(source.getUrl());
        }
    }
}
