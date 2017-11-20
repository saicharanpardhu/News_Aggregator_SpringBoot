package com.stackroute.news.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import com.stackroute.news.domain.*;
import com.stackroute.news.service.*;
import com.stackroute.news.controller.*;
import com.stackroute.news.repositories.*;

@RestController
@RequestMapping("/news/{userId}")
public class UserController {
	@Autowired
	private UserDAOcrud userDAOcrud;
	
	@GetMapping("")
	public boolean userValidate(@PathVariable String userId,@RequestParam(value="userPassword",required = true) String userPassword) {
		
		User user = userDAOcrud.findOne(userId);
		
		if(userPassword.equals(user.getUserPassword()))
		return true;
		else
		return false;	
	}
	@PostMapping("")
	public boolean userSignup(@RequestBody  User user) {
		
		userDAOcrud.save(user);
		
		return true;
	}
	
	
}
