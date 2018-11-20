package com.example.orihb.autodesknewsapp.ui.main.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orihb.autodesknewsapp.R;
import com.example.orihb.autodesknewsapp.ui.main.MainViewModel;
import com.example.orihb.autodesknewsapp.ui.main.adapter.NewsTitlesRecyclerViewAdapter;

import java.util.List;

public class NewsTitlesFragment extends Fragment {

    private MainViewModel mViewModel;
    private RecyclerView titlesRecyclerView;
    private NewsTitlesRecyclerViewAdapter titlesAdapter;

    public static NewsTitlesFragment newInstance() {
        return new NewsTitlesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.news_titles_fragment, container, false);

        getNewsItems();

        titlesRecyclerView = rootView.findViewById(R.id.news_titles_fragment_titles_recyclerview);

        titlesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(titlesRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        //List<Vehicle> vehicles = getModel().getVehicles().getValue();
        titlesRecyclerView.addItemDecoration(dividerItemDecoration);
        titlesRecyclerView.setItemAnimator(null);
        //titlesRecyclerView.setHasFixedSize(true);
        titlesAdapter = new NewsTitlesRecyclerViewAdapter(null);
        titlesRecyclerView.setAdapter(titlesAdapter);



        return rootView;
    }


    private void getNewsItems(){
        


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}
