package com.pi.MinuteBrico.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {

	@Id
	private int id;
	private String email;
	private String firstName;

	private String lastName;
	//@JsonView(View.Commandes.class)
	private String birthDate;
	private String password;
	private String role;
	@Column(length = 256)
	private String creationDate;
	
	public User() {
		super();
	}
	public User(int id) {
		this.id = id;
	}
	public User(int id, String email, String firstName, String lastName, String birthDate, String password, String role,
			String creationDate) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.password = password;
		this.role = role;
		this.creationDate = creationDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public User(Map<String,Object> userMap) {
		super();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime today = LocalDateTime.now();

		if (userMap.get("id") != null)
		
		this.id = (int )userMap.get("id");
		this.email = (String) userMap.get("email");
		this.firstName = (String) userMap.get("firstName");
		this.lastName = (String) userMap.get("lastName");
		this.birthDate = (String) userMap.get("birthDate");
		this.password = (String) userMap.get("password");
		this.role = (String) userMap.get("role");
		this.creationDate =  formatter.format(today);
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", birthDate=" + birthDate + ", password=" + password + ", role=" + role + "]";
	}
	
}
