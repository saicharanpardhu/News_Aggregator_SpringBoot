package com.stackroute.news.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import com.stackroute.news.domain.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.stackroute.news.service.*;
import com.stackroute.news.controller.*;
import com.stackroute.news.repositories.*;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.MediaType;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/news/{userId}/articles/")
public class WebController {
	@Autowired
	private SavedArticleDAO savedArticleDAO;
	
	@RequestMapping(value="{categoryId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SavedArticle> getArticles(@PathVariable String categoryId,@PathVariable String userId) {
		List<SavedArticle> articles = savedArticleDAO.findByUserIdAndArticleCategory(userId,categoryId);
        return articles;
    }
	
	
	@RequestMapping(value="{categoryId}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addArticles(@PathVariable String categoryId,@PathVariable String userId,@RequestBody SavedArticle article) {
		
		boolean flag = savedArticleDAO.save(article) != null;
        if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        return new ResponseEntity<Void>( HttpStatus.CREATED);
    }
	@RequestMapping(value="{categoryId}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteArticle( @RequestParam(value="id",required = true) String id,@PathVariable String userId,@PathVariable String categoryId) {
		SavedArticle article= savedArticleDAO.findById(id);
		savedArticleDAO.delete(article);
		return new ResponseEntity<String>("Deleted succesfully",HttpStatus.NO_CONTENT);
    }
	/*@Autowired
	private IArticleService articleService;
	
	@RequestMapping(value="{categoryId}/{articleId}",method = RequestMethod.GET)
    public Article getArticles(@PathVariable String categoryId,@PathVariable String userId,@PathVariable long articleId) {
		Article article = articleService.getArticleById(articleId);
        return article;
    }
	@RequestMapping(value="{categoryId}",method = RequestMethod.GET)
    public List<Article> getallArticles(@PathVariable String categoryId,@PathVariable String userId) {
		return articleService.getAllArticles();
    }
	
	@RequestMapping(value="{categoryId}",method = RequestMethod.POST)
    public ResponseEntity<Void> addArticles(@PathVariable String categoryId,@PathVariable String userId,@RequestBody Article article) {
		
		boolean flag = articleService.addArticle(article);
        if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        return new ResponseEntity<Void>( HttpStatus.CREATED);
    }
	
	@RequestMapping(value="{categoryId}",method = RequestMethod.PUT)
    public ResponseEntity<Article>  updateArticle(@RequestParam(value="articleId",required = true) long articleId,@PathVariable String userId,@RequestBody Article article) {
		
		articleService.updateArticle(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
        
    }
	
	@RequestMapping(value="{categoryId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteArticle(@RequestParam(value="articleId",required= true) long articleId,@PathVariable String userId) {
        
		articleService.deleteArticle(articleId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }*/
}
