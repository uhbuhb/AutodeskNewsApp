package com.example.orihb.autodesknewsapp.fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.orihb.autodesknewsapp.R;

public class ArticleFragment extends Fragment {
    private static final String ARG_URL = "url";

    private String url;
    private WebView webView;
    private ProgressBar progressBar;


    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance(String url) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(ARG_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_article, container, false);
        webView = rootview.findViewById(R.id.fragment_article_webview);
        progressBar = rootview.findViewById(R.id.fragment_article_progressbar);
        loadUrl();
        return rootview;

    }

    private void loadUrl() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        }
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                if (!isDetached() && isAdded()) {
                    super.onPageFinished(view, url);
                    progressBar.setVisibility(View.INVISIBLE);
                    webView.setVisibility(View.VISIBLE);
                }
            }
        });

    }

}
