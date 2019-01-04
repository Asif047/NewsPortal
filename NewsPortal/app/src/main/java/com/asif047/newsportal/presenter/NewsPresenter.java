package com.asif047.newsportal.presenter;

import com.asif047.newsportal.model.Article;
import com.asif047.newsportal.model.News;
import com.asif047.newsportal.service.NewService;
import com.asif047.newsportal.view.NewsView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 1/5/2019.
 */

public class NewsPresenter {

    private NewsView newsView;
    private NewService newService;

    public NewsPresenter(NewsView newsView) {
        this.newsView = newsView;

        if(this.newService == null) {
            this.newService = new NewService();
        }
    }


    public void getNews() {
        newService
                .getAPI()
                .getNews("international", "publishedAt", "8e6783df364f45559154fd9e4c1a4380")
                .enqueue(new Callback<News>() {
                    @Override
                    public void onResponse(Call<News> call, Response<News> response) {
                        News news = response.body();
                        if(news != null && news.getArticles() !=null){
                            List<Article> articles = news.getArticles();
                            newsView.newsReady(articles);
                        }
                    }

                    @Override
                    public void onFailure(Call<News> call, Throwable t) {

                        try{
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });
    }

}
