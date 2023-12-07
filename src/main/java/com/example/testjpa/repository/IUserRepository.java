package com.example.testjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.testjpa.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

//	custom query
	@Query("SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<User> findByNameUsingQuery(@Param("name") String name);
    
}
