package com.stackroute.news.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Articles")
public class Article implements Serializable {

	public Article(long articleId, String articleHeadline, String articleURL, String articleDescription,
			String articleAuthor, String articleImageURL, String articleTime) {
		super();
		this.articleId = articleId;
		this.articleHeadline = articleHeadline;
		this.articleURL = articleURL;
		this.articleDescription = articleDescription;
		this.articleAuthor = articleAuthor;
		this.articleImageURL = articleImageURL;
		this.articleTime = articleTime;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long articleId;
	@Column(name="articleHeadline")
	private String articleHeadline;
	@Column(name="articleURL")
	private String articleURL;
	@Column(name="articleDescription")
	private String articleDescription;
	@Column(name="articleAuthor")
	private String articleAuthor;
	@Column(name="articleImageURL")
	private String articleImageURL;
    @Column(name="articleTime")
	private String articleTime;
	
	
	public long getArticleId() {
		return articleId;
	}
	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}
	public String getArticleHeadline	() {
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
	public String getArticleDescription() {
		return articleDescription;
	}
	public void setArticleDescription(String articleDescription) {
		this.articleDescription = articleDescription;
	}
	public String getArticleTime() {
		return articleTime;
	}
	public void setArticleTime(String articleTime) {
		this.articleTime = articleTime;
	}
	
	
}
