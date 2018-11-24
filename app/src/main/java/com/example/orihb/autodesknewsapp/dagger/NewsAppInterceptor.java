package com.example.orihb.autodesknewsapp.dagger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

class NewsAppInterceptor implements Interceptor {

    private String apiKey;

    public NewsAppInterceptor(String apiKey){
        this.apiKey = apiKey;
    }


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("X-Api-key", apiKey).build();
        return chain.proceed(request);
    }
}
