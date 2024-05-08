package com.example.newsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.newsapp.Adapter.ArticlesListAdapter;
import com.example.newsapp.Interface.ArticlesListResponseInterface;
import com.example.newsapp.PojoFile.ArticlesListResponse;
import com.example.newsapp.PojoFile.ErrorBody;
import com.example.newsapp.ViewModel.ArticlesListViewModel;


public class MainActivity extends AppCompatActivity implements ArticlesListResponseInterface {


    private ArticlesListAdapter articlesListAdapter;
    private RecyclerView view_news;

    private ProgressBar Progress_Bar;
    private SwipeRefreshLayout SwipeRefresh;

    public ArticlesListViewModel articlesListViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view_news = findViewById(R.id.ViewArticles);
        Progress_Bar = findViewById(R.id.Progress_Bar);
        SwipeRefresh = findViewById(R.id.SwipeRefresh);
        articlesListViewModel = new ArticlesListViewModel();
        articlesListViewModel.ArticlesListCallEnqueue(this);
        Progress_Bar.setVisibility(View.GONE);


        SwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                articlesListViewModel.ArticlesListCallEnqueue(MainActivity.this);
                SwipeRefresh.setRefreshing(false);
            }
        });
        SwipeRefresh.setRefreshing(true);
    }


    @Override
    public void ArticlesListResponseProcess(ArticlesListResponse articlesListResponse) {
        if (articlesListResponse != null) {
            if (articlesListResponse.getPrevious() == null) {
                Progress_Bar.setVisibility(View.GONE);
                articlesListAdapter = new ArticlesListAdapter(getApplicationContext(), articlesListResponse.getResults());
                view_news.setLayoutManager(new LinearLayoutManager(this));
                view_news.setAdapter(articlesListAdapter);
                SwipeRefresh.setRefreshing(false);
            } else {
                Progress_Bar.setVisibility(View.GONE);
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
                SwipeRefresh.setRefreshing(false);
            }
        }
    }

    @Override
    public void onFailure(ErrorBody errorBody, int statusCode) {
    }

    @Override
    public void onFailureURL(String url) {

    }
}

