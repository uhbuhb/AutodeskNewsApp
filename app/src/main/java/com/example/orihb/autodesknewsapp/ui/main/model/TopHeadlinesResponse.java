package com.example.orihb.autodesknewsapp.ui.main.model;

import java.util.Dictionary;

public class TopHeadlinesResponse {

    private Source source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public Source getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getContent() {
        return content;
    }


    //    {
//        -"source": {
//        "id": "the-new-york-times",
//                "name": "The New York Times"
//    },
//        "author": null,
//            "title": "Amazon, Apple and Facebook Once Led the Market. Now They Are Driving it Down.",
//            "description": null,
//            "url": "https://www.nytimes.com/2018/11/19/business/tech-stocks-markets-slump.html",
//            "urlToImage": null,
//            "publishedAt": "2018-11-20T10:44:22Z",
//            "content": null
//    }

}
