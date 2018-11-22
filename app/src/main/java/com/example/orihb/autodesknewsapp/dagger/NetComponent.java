package com.example.orihb.autodesknewsapp.dagger;

import com.example.orihb.autodesknewsapp.MainActivity;
import com.example.orihb.autodesknewsapp.dagger.AppModule;
import com.example.orihb.autodesknewsapp.dagger.NetModule;
import com.example.orihb.autodesknewsapp.fragment.NewsTitlesFragment;

import javax.inject.Singleton;
import dagger.Component;



@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
    void inject(NewsTitlesFragment fragment);

}