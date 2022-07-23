package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.entity.User;

//DAO, 자동으로 빈으로 등록된다.
//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
//1. JPA Naming 방식
// User findByUsernameAndPassword(String username, String password);

// 2. native Query 방식
// @Query(value="SELECT * FROM user WHERE username = ?1 AND
// password=?2",nativeQuery = true)
// User login(String username, String password);
