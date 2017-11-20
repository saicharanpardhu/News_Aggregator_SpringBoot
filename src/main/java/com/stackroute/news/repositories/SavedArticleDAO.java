package com.stackroute.news.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import com.stackroute.news.domain.*;
import java.util.List;
@Transactional
public interface SavedArticleDAO extends MongoRepository<SavedArticle,String>{
	
	List<SavedArticle> findByUserIdAndArticleCategory(String userId, String articleCategory);
	SavedArticle findById(String id);
	void delete(SavedArticle savedArticle);
}
