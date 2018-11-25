package com.example.orihb.autodesknewsapp.dagger;

import com.example.orihb.autodesknewsapp.fragment.NewsTitlesFragment;

import javax.inject.Singleton;
import dagger.Component;


@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(NewsTitlesFragment fragment);

}