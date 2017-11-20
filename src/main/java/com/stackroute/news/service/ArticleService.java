package com.stackroute.news.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.news.repositories.IArticleDAO;
import com.stackroute.news.domain.Article;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	public void setArticleDAO(IArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}
	@Override
	public Article getArticleById(long articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		return articleDAO.getAllArticles();
	}
	@Override
	public synchronized boolean addArticle(Article article){
                if (articleDAO.articleExists(article.getArticleDescription(), article.getArticleHeadline())) {
    	            return false;
                } else {
    	            articleDAO.addArticle(article);
    	            return true;
                }
	}
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	@Override
	public void deleteArticle(long articleId) {
		articleDAO.deleteArticle(articleId);
	}
} 