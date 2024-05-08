package com.example.newsapp.Http;

import com.example.newsapp.PojoFile.ArticlesListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET(ApiClass.ARTICLESLIST)
    Call<ArticlesListResponse> ArticlesListCall();
}
