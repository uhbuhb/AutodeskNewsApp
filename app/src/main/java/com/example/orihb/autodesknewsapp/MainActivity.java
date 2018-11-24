package com.example.orihb.autodesknewsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orihb.autodesknewsapp.fragment.NewsTitlesFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, NewsTitlesFragment.newInstance())
                    .commitNow();
        }

    }


}

