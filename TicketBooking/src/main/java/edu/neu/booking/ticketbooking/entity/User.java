package edu.neu.booking.ticketbooking.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "username")
	private String username;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "password")
	private String password;

	// constructors, getters and setters

	public User(String name, String email, String phone, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
