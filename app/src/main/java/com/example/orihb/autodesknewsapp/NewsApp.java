package com.example.orihb.autodesknewsapp;

import android.app.Application;

import com.example.orihb.autodesknewsapp.dagger.AppModule;
import com.example.orihb.autodesknewsapp.dagger.DaggerNetComponent;
import com.example.orihb.autodesknewsapp.dagger.NetComponent;
import com.example.orihb.autodesknewsapp.dagger.NetModule;

public class NewsApp extends Application {

    private NetComponent netComponent;
    private static final String API_BASE_URL = "http://newsapi.org/v2/";
    private static final String APIKEY = "394973a182a744e0ae10cc8f3a32b71d";

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(API_BASE_URL, APIKEY))
                .build();

    }

    public NetComponent getNetComponent() {
        return netComponent;
    }


}
