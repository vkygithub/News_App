package com.example.newsapp.ViewModel;

import com.example.newsapp.Http.ApiClient;
import com.example.newsapp.Http.ApiInterface;
import com.example.newsapp.Interface.ArticlesListResponseInterface;
import com.example.newsapp.PojoFile.ArticlesListResponse;
import com.example.newsapp.PojoFile.ErrorBody;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesListViewModel {
    private ApiInterface apiInterface = ApiClient.apiinterface();
    private ArticlesListResponseInterface articlesListResponseInterface;

    public void ArticlesListCallEnqueue(ArticlesListResponseInterface articlesListResponseInterface) {
        this.articlesListResponseInterface = articlesListResponseInterface;

        apiInterface.ArticlesListCall().enqueue(new Callback<ArticlesListResponse>() {
            /**
             * @param call
             * @param response
             * @brief getting response from api
             */
            @Override
            public void onResponse(Call<ArticlesListResponse> call, Response<ArticlesListResponse> response) {
                /**
                 * Invoked for a received HTTP response.
                 *
                 *
                 * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                 * Call [Response.isSuccessful] to determine if the response indicates success.
                 *
                 * @param call
                 * @param response
                 */
                System.out.println("response get");
                int statusCode = response.code();

                //if response is successful set the body of response to onSuccess methode in GenerateRegisterResponseModel else get the error body and set on onFailure in generateRegisterResponseModel
                if (response.isSuccessful()) {
                    articlesListResponseInterface.ArticlesListResponseProcess(response.body());
                } else {
                    String serviceResponse;
                    try {
                        serviceResponse = response.errorBody().string();
                        ErrorBody errorBody = new Gson().fromJson(serviceResponse, ErrorBody.class);
                        articlesListResponseInterface.onFailure(errorBody, statusCode);
                    } catch (JsonSyntaxException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ArticlesListResponse> call, Throwable t) {
                System.out.println("onTokenExpired: " + t.getMessage());
            }

            /**
             * @param call
             * @param t
             * @brief api call failure
             */


        });
    }
}