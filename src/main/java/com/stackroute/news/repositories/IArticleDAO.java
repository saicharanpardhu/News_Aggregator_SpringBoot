package com.stackroute.news.repositories;
import java.util.List;
import com.stackroute.news.domain.Article;
public interface IArticleDAO {
	List<Article> getAllArticles();
    Article getArticleById(long articleId);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(long articleId);
    boolean articleExists(String title, String category);
}
