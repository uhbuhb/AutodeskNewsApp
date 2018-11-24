package com.example.orihb.autodesknewsapp.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orihb.autodesknewsapp.ApiService;
import com.example.orihb.autodesknewsapp.NewsApp;
import com.example.orihb.autodesknewsapp.R;
import com.example.orihb.autodesknewsapp.impl.ArticleInteraction;
import com.example.orihb.autodesknewsapp.model.Article;
import com.example.orihb.autodesknewsapp.model.MainViewModel;
import com.example.orihb.autodesknewsapp.adapter.NewsTitlesRecyclerViewAdapter;
import com.example.orihb.autodesknewsapp.model.TopHeadlinesResponse;

import java.util.List;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsTitlesFragment extends Fragment implements ArticleInteraction {

    private RecyclerView titlesRecyclerView;
    private NewsTitlesRecyclerViewAdapter titlesAdapter;
    @Inject
    ApiService apiService;

    public static NewsTitlesFragment newInstance() {
        return new NewsTitlesFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((NewsApp) getActivity().getApplication()).getNetComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news_titles_fragment, container, false);
        getNewsItems();
        titlesRecyclerView = rootView.findViewById(R.id.news_titles_fragment_titles_recyclerview);

        return rootView;
    }


    private void getNewsItems(){
        apiService.getTopHeadlines().enqueue(new Callback<TopHeadlinesResponse>()
        {
            @Override
            public void onResponse(Call<TopHeadlinesResponse> call, Response<TopHeadlinesResponse> response) {
                fillRecyclerView(response.body().getArticles());

            }

            @Override
            public void onFailure(Call<TopHeadlinesResponse> call, Throwable t) {
                Log.i("oriApp","failure");
            }
        });

    }


    private void fillRecyclerView(List<Article> articles) {
        titlesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(titlesRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        titlesRecyclerView.addItemDecoration(dividerItemDecoration);
        titlesRecyclerView.setItemAnimator(null);
        titlesAdapter = new NewsTitlesRecyclerViewAdapter(articles, this);
        titlesRecyclerView.setAdapter(titlesAdapter);

    }


    @Override
    public void onArticleClicked(String articleUrl) {
        replaceFragment(articleUrl);

    }


    public void replaceFragment(String articleUrl){
        ArticleFragment fragment = ArticleFragment.newInstance(articleUrl);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        getNewsItems();
    }

}
