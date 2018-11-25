package com.example.orihb.autodesknewsapp.adapter;


import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.orihb.autodesknewsapp.R;
import com.example.orihb.autodesknewsapp.impl.ArticleInteraction;
import com.example.orihb.autodesknewsapp.model.Article;

import java.util.List;

public class NewsTitlesRecyclerViewAdapter extends RecyclerView.Adapter<NewsTitlesRecyclerViewAdapter.NewsArticleTitleViewHolder> {

    private List<Article> newsArticles;
    private ArticleInteraction listener;

    public NewsTitlesRecyclerViewAdapter(List<Article> articles, ArticleInteraction listener){
        this.newsArticles = articles;
        this.listener = listener;
    }


    @Override
    public NewsArticleTitleViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_title_view_holder, viewGroup, false);
        NewsArticleTitleViewHolder viewHolder = new NewsArticleTitleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleTitleViewHolder newsArticleTitleViewHolder, int i) {
        newsArticleTitleViewHolder.bind(newsArticles.get(i));
    }


    @Override
    public int getItemCount() {
        return this.newsArticles.size();
    }

    public class NewsArticleTitleViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView datePublishedTextView;
        private final ImageView articleImageView;
        private final ProgressBar progressBar;
        private Article newsArticle;

        public NewsArticleTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            View layout = itemView.findViewById(R.id.news_titles_viewholder_layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onArticleClicked(newsArticle.getUrl());
                }
            });
            titleTextView = itemView.findViewById(R.id.news_titles_viewholder_title_textview);
            datePublishedTextView = itemView.findViewById(R.id.news_titles_viewholder_date_published_textview);
            articleImageView = itemView.findViewById(R.id.news_titles_viewholder_imageview);
            progressBar = itemView.findViewById(R.id.news_titles_viewholder_imageloading_progressbar);

        }

        public void bind(Article article) {
            this.newsArticle = article;
            this.titleTextView.setText(newsArticle.getTitle());
            this.datePublishedTextView.setText(newsArticle.getPublishedAt());
            Glide.with(titleTextView.getContext())
                    .load(newsArticle.getUrlToImage())
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            progressBar.setVisibility(View.INVISIBLE);
                            articleImageView.setVisibility(View.VISIBLE);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.INVISIBLE);
                            articleImageView.setVisibility(View.VISIBLE);
                            return false;
                        }
                    })
                    .into(this.articleImageView);

        }

    }
}
