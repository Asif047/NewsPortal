package com.asif047.newsportal.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asif047.newsportal.R;
import com.asif047.newsportal.model.Article;
import com.asif047.newsportal.model.News;
import com.asif047.newsportal.presenter.NewsPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NewsView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsPresenter newsPresenter= new NewsPresenter(this);
        newsPresenter.getNews();
    }

    @Override
    public void newsReady(List<Article> articles) {


        for(Article article: articles) {
            Log.e("RETROFIT: ", articles.get(0).getAuthor());
        }

    }
}
