package com.example.orihb.autodesknewsapp.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orihb.autodesknewsapp.ApiService;
import com.example.orihb.autodesknewsapp.MainActivity;
import com.example.orihb.autodesknewsapp.R;
import com.example.orihb.autodesknewsapp.model.MainViewModel;
import com.example.orihb.autodesknewsapp.adapter.NewsTitlesRecyclerViewAdapter;
import com.example.orihb.autodesknewsapp.model.TopHeadlinesResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsTitlesFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView titlesRecyclerView;
    private NewsTitlesRecyclerViewAdapter titlesAdapter;
    private ApiService apiService;

    public static NewsTitlesFragment newInstance() {
        return new NewsTitlesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news_titles_fragment, container, false);
        getApiService();
        //getTest();
        getNewsItems();

        titlesRecyclerView = rootView.findViewById(R.id.news_titles_fragment_titles_recyclerview);

        titlesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(titlesRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        titlesRecyclerView.addItemDecoration(dividerItemDecoration);
        titlesRecyclerView.setItemAnimator(null);
        //titlesRecyclerView.setHasFixedSize(true);
        titlesAdapter = new NewsTitlesRecyclerViewAdapter(null);
        titlesRecyclerView.setAdapter(titlesAdapter);



        return rootView;
    }


    private void getNewsItems(){
        apiService.getTopHeadlines().enqueue(new Callback<TopHeadlinesResponse>()
        {
            @Override
            public void onResponse(Call<TopHeadlinesResponse> call, Response<TopHeadlinesResponse> response) {
                Log.i("oriApp","response: " + response);
            }

            @Override
            public void onFailure(Call<TopHeadlinesResponse> call, Throwable t) {
                Log.i("oriApp","failure");
            }
        });

    }

    private void getTest(){
        apiService.getTest().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("oriApp",response.toString());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("oriApp","failure");
            }
        });

    }


    private void getApiService(){
        MainActivity activity = (MainActivity) getActivity();
        apiService = activity.getApiService();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}
