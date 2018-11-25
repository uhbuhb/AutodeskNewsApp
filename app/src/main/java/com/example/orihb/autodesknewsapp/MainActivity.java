package com.example.orihb.autodesknewsapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orihb.autodesknewsapp.fragment.NewsTitlesFragment;

public class MainActivity extends AppCompatActivity {

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


    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment != null && fragment instanceof NewsTitlesFragment) {
            NewsTitlesFragment newsTitlesFragment = (NewsTitlesFragment) fragment;
            newsTitlesFragment.onFragmentResume();
        }

        super.onBackPressed();
    }
}

