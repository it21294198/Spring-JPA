package com.example.testjpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//Lombok annotations
@Getter // add getters for all attributes
@Setter // add setters for all attributes
@ToString // make toString function
// @NoArgsConstructor //add default constructor
@AllArgsConstructor // parameterized constructor with all attributes
@Entity
@Table(name = "User")
public class User {

	@Id // primary key
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.AUTO) // auto increment value
	@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 1, allocationSize = 1)
	private Integer id;

	private String name;

	private String email;

	@Column(length = 8)
	private String password;

	public User() {
		super();
	}

	// User constructor without id entity
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public void ShowUser() {
		System.out.println(this.name);
	}

	// Lombok doesn't work somewhat reason
	public void setName(String name2) {
		this.name = name2;
	}

}
