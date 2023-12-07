package com.example.testjpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.testjpa.model.User;
import com.example.testjpa.service.IUserService;

@SpringBootApplication
public class TestJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TestJpaApplication.class, args);
	}

	@Autowired
	private IUserService userService; //filed based dependency injection (no need setters)
	
	@Override
	public void run(String... args) throws Exception {
		
//		add new user to database
		try {
			User user = new User("name","hi we","afdswrd");
			User newUser = userService.addUser(user);
			System.out.println(newUser);
		}catch (Exception e) {
			System.out.println(e);
		}
		
//		view a data in database
		try {
			User user = userService.getUserById(3);
			user.ShowUser();
		} catch (Exception e) {
			System.out.println(e);
		}
		
//	view all data in database
	try {
//		List<User> users = userService.getAllUser();
//		for(User user:users) {
//			System.out.println(user);
//		}
//		or
		userService.getAllUser().forEach(System.out::println);
	} catch (Exception e) {
		System.out.println(e);
	}
		
//	view all data for given name into database
	try {
//		List<User> users = userService.getUserEqualName("hi");
//		for(User user:users) {
//			System.out.println(user);
//		}
//		or
		userService.getUserEqualName("hi").forEach(System.out::println);
	} catch (Exception e) {
		 e.printStackTrace();
		System.out.println(e);
	}
		
//		update user
		try {
			User updatedUser = userService.updateUserName(4,"hello");
			System.out.println(updatedUser);
		} catch (Exception e) {
			System.out.println(e);
		}

//		delete user
		try {
			userService.deleteUser(1);
			System.out.println("user is deleted");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
