package com.example.orihb.autodesknewsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orihb.autodesknewsapp.ui.main.MainFragment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String API_BASE_URL = "https://newsapi.org/v2/";
    private static final String APIKEY = "394973a182a744e0ae10cc8f3a32b71d";
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

    }
}

