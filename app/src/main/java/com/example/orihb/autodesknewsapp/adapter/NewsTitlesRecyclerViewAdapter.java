package com.example.orihb.autodesknewsapp.adapter;


import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orihb.autodesknewsapp.R;
import com.example.orihb.autodesknewsapp.model.Article;
import com.example.orihb.autodesknewsapp.model.TopHeadlinesResponse;

import java.util.List;

public class NewsTitlesRecyclerViewAdapter extends RecyclerView.Adapter<NewsTitlesRecyclerViewAdapter.NewsArticleTitleViewHolder> {

    private List<Article> newsArticles;

    public NewsTitlesRecyclerViewAdapter(List<Article> articles){
        this.newsArticles = articles;

    }


    @Override
    public NewsArticleTitleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_title_view_holder, viewGroup, false);
        NewsArticleTitleViewHolder viewHolder = new NewsArticleTitleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleTitleViewHolder newsArticleTitleViewHolder, int i) {
        newsArticleTitleViewHolder.bind(i, newsArticles.get(i));
//        Article article = newsArticles.get(i);
//        newsArticleTitleViewHolder.newsArticle = article;
//        newsArticleTitleViewHolder.position = i;
//        newsArticleTitleViewHolder.titleTextView.setText(article.getTitle());
//        newsArticleTitleViewHolder.datePublishedTextView.setText(article.getPublishedAt());
        //newsArticleTitleViewHolder.articleImageView.setImageURI(Uri.parse(article.getUrlToImage()));

    }


    @Override
    public int getItemCount() {
        return this.newsArticles.size();
    }

    public class NewsArticleTitleViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView datePublishedTextView;
        private final ImageView articleImageView;
        private Article newsArticle;
        private int position;

        public NewsArticleTitleViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.news_titles_viewholder_title_textview);
            datePublishedTextView = itemView.findViewById(R.id.news_titles_viewholder_date_published_textview);
            articleImageView = itemView.findViewById(R.id.news_titles_viewholder_imageview);

        }

        public void bind(int position, Article article) {
            this.newsArticle = article;
            this.position = position;
            this.titleTextView.setText(newsArticle.getTitle());
            this.datePublishedTextView.setText(newsArticle.getPublishedAt());
            //this.articleImageView.setImageURI(Uri.parse(newsArticle.getUrlToImage()));

        }


    }
}
