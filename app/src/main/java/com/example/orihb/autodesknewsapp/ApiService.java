package com.example.orihb.autodesknewsapp;
import com.example.orihb.autodesknewsapp.ui.main.model.TopHeadlinesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiService {

    @GET("top-headlines?country=us&apiKey=394973a182a744e0ae10cc8f3a32b71d")
    Call<List<TopHeadlinesResponse>> getTopHeadlines(String apiKey);


//    curl https://newsapi.org/v2/top-headlines -G \
//            -d country=us \
//            -d apiKey=394973a182a744e0ae10cc8f3a32b71d


}
