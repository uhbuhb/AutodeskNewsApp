package com.example.orihb.autodesknewsapp.dagger;


import com.example.orihb.autodesknewsapp.ApiService;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    private String apiKey;
    private String baseUrl;

    public NetModule(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }


    @Provides
    @Singleton
    GsonConverterFactory provideGson() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new NewsAppInterceptor(apiKey));
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(GsonConverterFactory gson, OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(gson)
                .client(client)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

}
