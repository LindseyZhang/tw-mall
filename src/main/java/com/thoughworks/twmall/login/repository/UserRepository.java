package com.thoughworks.twmall.login.repository;

import com.thoughworks.twmall.login.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
