package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String first_Name;

	@Column(name="last_name")
	private String last_Name;
	
	@Column(name="email")
	private String email;
	
	public Customer() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_Name;
	}

	public void setFirstName(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLastName() {
		return last_Name;
	}

	public void setLastName(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", email=" + email + "]";
	}

}
