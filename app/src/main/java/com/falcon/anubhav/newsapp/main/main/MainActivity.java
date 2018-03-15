package com.falcon.anubhav.newsapp.main.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.falcon.anubhav.newsapp.R;
import com.falcon.anubhav.newsapp.main.adapter.NewsAdapter;
import com.falcon.anubhav.newsapp.main.model.Sources;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private MainPresenter mainPresenter;
    private NewsAdapter newsAdapter;

//    @Inject
//    Context context;

//    @Inject
//    NewsApiInterface newsApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

       // ((NewsApplication) context.getApplicationContext()).getNewsComponent().inject(this);

        mainPresenter = new MainPresenter(this, new MainInteractor());
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItem(List<Sources> sources, String message) {
        newsAdapter = new NewsAdapter(sources);
        recyclerView.setAdapter(newsAdapter);
    }

    @Override
    public void setErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }

    @Override
    protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }
}
