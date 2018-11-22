package com.example.orihb.autodesknewsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orihb.autodesknewsapp.fragment.NewsTitlesFragment;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //private static final String API_BASE_URL = "https://newsapi.org/";
    private static final String APIKEY = "394973a182a744e0ae10cc8f3a32b71d";
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, NewsTitlesFragment.newInstance())
                    .commitNow();
        }

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader("X-Api-key", APIKEY).build();
                return chain.proceed(request);
            }
        });


        OkHttpClient client = builder.build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(ApiService.class);

    }

    public ApiService getApiService() {
        return apiService;
    }

}

