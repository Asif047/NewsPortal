package com.asif047.newsportal.view;

import com.asif047.newsportal.model.Article;
import com.asif047.newsportal.model.News;

import java.util.List;

/**
 * Created by admin on 1/5/2019.
 */

public interface NewsView {

    void newsReady(List<Article> articles);

}
