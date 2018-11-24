package com.example.orihb.autodesknewsapp;
import com.example.orihb.autodesknewsapp.model.TopHeadlinesResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface ApiService {

    @Headers("X-Api-Key: 394973a182a744e0ae10cc8f3a32b71d")
    //@GET("top-headlines?country=us&apiKey=394973a182a744e0ae10cc8f3a32b71d")
    @GET("top-headlines?country=us")
    Call<TopHeadlinesResponse> getTopHeadlines();


    @GET("https://api.ipify.org?format=json")
    Call<ResponseBody> getTest();


}
