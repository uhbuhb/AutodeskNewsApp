package com.example.orihb.autodesknewsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orihb.autodesknewsapp.fragment.NewsTitlesFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String API_BASE_URL = "https://newsapi.org/";
    private static final String APIKEY = "394973a182a744e0ae10cc8f3a32b71d";
    @Inject ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsTitlesFragment.newInstance())
                    .commitNow();
        }
        ((NewsApp) getApplication()).getNetComponent().inject(this);
    }

}

