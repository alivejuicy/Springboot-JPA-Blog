package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;

//DAO, 자동으로 빈으로 등록된다.
@Repository
public interface UserRepository extends JpaRepository<User, Integer> { 

}
