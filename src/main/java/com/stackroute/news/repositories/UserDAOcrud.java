package com.stackroute.news.repositories;
import org.springframework.data.repository.CrudRepository;

import com.stackroute.news.domain.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserDAOcrud extends CrudRepository<User, String> {

}

