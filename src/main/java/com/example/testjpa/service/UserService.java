package com.example.testjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testjpa.exception.UserNotFoundException;
import com.example.testjpa.model.User;
import com.example.testjpa.repository.IUserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UserService implements IUserService{
	
	private IUserRepository userRepository;

	@Autowired
	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User addUser(User user) {
		User userSet = userRepository.save(user);
		return userSet;
	}

//	user update part start from here
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public User updateUserName(int id,String name) {
		 User existingUser = entityManager.find(User.class, id);

	        if (existingUser != null) {
	            // Update the properties of the existing user
	            existingUser.setName(name);

	            // Save the updated user back to the database
	            entityManager.merge(existingUser);

	            return existingUser;
	        } else {
	            return null;
	        }
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
//		Optional<User> user = userRepository.findById(id);
//		if(user.isEmpty()) {
//			throw new UserNotFoundException("Invalid id");
//		}
//		return user.get(); // or same as following method
//		or
		return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("Invalid id"));
	}

	@Override
	public List<User> getAllUser() throws UserNotFoundException {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUserEqualName(String name) throws UserNotFoundException {
		return userRepository.findByNameUsingQuery(name);
	}

}
