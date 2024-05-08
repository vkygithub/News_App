package com.example.newsapp.Interface;

import com.example.newsapp.PojoFile.ArticlesListResponse;
import com.example.newsapp.PojoFile.ErrorBody;

import java.util.List;

public interface ArticlesListResponseInterface {
    void ArticlesListResponseProcess(ArticlesListResponse articlesListResponse);

    void onFailure(ErrorBody errorBody, int statusCode);

    void onFailureURL(String url);
}
