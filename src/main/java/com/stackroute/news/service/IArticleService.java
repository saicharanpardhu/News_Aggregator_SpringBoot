package com.stackroute.news.service;

import java.util.List;
import com.stackroute.news.domain.Article;
public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(long articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(long articleId);
} 