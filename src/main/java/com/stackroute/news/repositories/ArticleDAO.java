package com.stackroute.news.repositories;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.stackroute.news.domain.Article;
@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Article getArticleById(long articleId) {
		return entityManager.find(Article.class, articleId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);
	}
	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		artcl.setArticleId(article.getArticleId());
		artcl.setArticleHeadline(article.getArticleHeadline());
		artcl.setArticleURL(article.getArticleURL());
		artcl.setArticleAuthor(article.getArticleAuthor());
		artcl.setArticleImageURL(article.getArticleImageURL());
		artcl.setArticleDescription(article.getArticleDescription());
		artcl.setArticleTime(article.getArticleTime());
		entityManager.flush();
	}
	@Override
	public void deleteArticle(long articleId) {
		entityManager.remove(getArticleById(articleId));
	}
	@Override
	public boolean articleExists(String description, String headline) {
		String hql = "FROM Article as atcl WHERE atcl.articleHeadline = ? and atcl.articleDescription = ?";
		int count = entityManager.createQuery(hql).setParameter(1, headline)
		              .setParameter(2, description).getResultList().size();
		return count > 0 ? true : false;
	}
} 