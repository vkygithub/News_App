package com.example.newsapp;

import android.os.Build;
import android.os.Bundle;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newsapp.ViewModel.ArticlesListViewModel;


public class Web_View extends AppCompatActivity {
    private WebView Web_View;
    public ArticlesListViewModel articlesListViewModel;
    private String website;

    @RequiresApi(Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        Web_View = findViewById(R.id.Web_View);
        articlesListViewModel = new ArticlesListViewModel();

        website = getIntent().getStringExtra("website").toString();
        Web_View.setWebViewClient(new WebViewClient());
        Web_View.loadUrl(website);
        Web_View.getSettings().setJavaScriptEnabled(true);
        Web_View.getSettings().setSupportZoom(true);
        Web_View.getSettings().setDomStorageEnabled(true);
        Web_View.getSettings().setSafeBrowsingEnabled(true);
    }
}

