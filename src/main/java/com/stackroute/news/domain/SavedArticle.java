package com.stackroute.news.domain;
import javax.persistence.Column;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="savedarticles")


public class SavedArticle implements Serializable {
	 
		
	
	
	@Id
	private String id;
	
	
	private String userId;
	private String articleCategory;
	private String articleHeadline;
	private String articleURL;
	private String articleDescription;
    private String articleAuthor;
	private String articleImageURL;
    private String articleTime;
    private String articleComment;
    
    public String getId() {
		return id;
	}
	public String getArticleComment() {
		return articleComment;
	}
	public void setArticleComment(String articleComment) {
		this.articleComment = articleComment;
	}
	public String getArticleCategory() {
		return articleCategory;
	}
	public void setArticleCategory(String articleCategory) {
		this.articleCategory = articleCategory;
	}
	public String getArticleHeadline() {
		return articleHeadline;
	}
	public void setArticleHeadline(String articleHeadline) {
		this.articleHeadline = articleHeadline;
	}
	public String getArticleURL() {
		return articleURL;
	}
	public void setArticleURL(String articleURL) {
		this.articleURL = articleURL;
	}
	public String getArticleDescription() {
		return articleDescription;
	}
	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
	public String getArticleAuthor() {
		return articleAuthor;
	}
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	public String getArticleImageURL() {
		return articleImageURL;
	}
	public void setArticleImageURL(String articleImageURL) {
		this.articleImageURL = articleImageURL;
	}
	public String getArticleTime() {
		return articleTime;
	}
	public void setArticleTime(String articleTime) {
		this.articleTime = articleTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
