package com.stackroute.news.controller;


import com.stackroute.news.*;
import com.stackroute.news.domain.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class WebControllerTest {
    String article1;
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    SavedArticle article;
    @Before
    public void setUp() throws Exception {
         article.getArticleAuthor();
         article.getArticleCategory();
         article.getArticleComment();
         article.getArticleDescription();
         article.getArticleHeadline();
         article.getArticleImageURL();
         article.getArticleTime();
         article.getArticleURL();
    }
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testSaveSavedArticle() throws Exception {
        HttpEntity<SavedArticle> entity = new HttpEntity<SavedArticle>(article, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/news/pardhu/articles/sports"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("SavedArticle saved successfully",actual);
    }

//   @Test
//    public void testdelete() throws Exception {
//        HttpEntity<SavedArticle> entity = new HttpEntity<SavedArticle>(article, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/news/pardhu/articles/Sports"),
//                HttpMethod.DELETE, entity, String.class);
//        assertNotNull(response);
//        String actual = response.getBody();
//        System.out.println(actual);
//        assertEquals("Deleted succesfully",actual);
//    }  
//   @Test
//    public void testupdate() throws Exception {
//        HttpEntity<SavedArticle> entity = new HttpEntity<SavedArticle>(article, headers);
//        ResponseEntity<String> response = restTemplate.exchange(
//                createURLWithPort("/goSavedArticle/updatearticle"),
//                HttpMethod.PUT, entity, String.class);
//        assertNotNull(response);
//        String actual = response.getBody();
//        System.out.println(actual);
//        assertEquals("SavedArticle updated successfully",actual);
//    }
//    
//   
//   @Test
//    public void testEGetSavedArticleByExistingId() throws Exception {
//        HttpEntity<SavedArticle> entity = new HttpEntity<SavedArticle>(article, headers);
//        ResponseEntity<SavedArticle> response = restTemplate.exchange(
//                createURLWithPort("/goSavedArticle/show/3"),
//                HttpMethod.GET, entity, SavedArticle.class);
//        
//      assertNotNull("Expected some value but found null",response);
//        assertEquals("Status code is not as expected",HttpStatus.OK,response.getStatusCode());      
//   }
    
//    @Test
//    public void testEGetSavedArticles() throws Exception {
//        List<SavedArticle> articles= new ArrayList();
//        articles.add(article);
//        HttpEntity<List<SavedArticle>> entity = new HttpEntity<List<SavedArticle>>(articles, headers);
//        ResponseEntity<SavedArticle> response = restTemplate.exchange(
//                createURLWithPort("/goSavedArticle/list"),
//                HttpMethod.GET, entity, SavedArticle.class);
//        
//       assertNotNull("Expected some value but found null",response);
//        assertEquals("Status code is not as expected",HttpStatus.OK,response.getStatusCode());      
//    }
    
   

}