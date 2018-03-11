package com.restaurant.model;

import java.util.Date;

public class User {
	private String firstName, lastName, email, password, uname, phone, egn;
	private int roles_id;
	private Date registration;

	public String getFirstName() {

		return this.firstName;
	}

	public void setFirstName(String firstName) {

		this.firstName = firstName;
	}

	public String getLastName() {

		return this.lastName;
	}

	public void setLastName(String lastName) {

		this.lastName = lastName;
	}

	public String getEmail() {

		return this.email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {

		return this.password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getUname() {

		return this.uname;
	}

	public void setUname(String uname) {

		this.uname = uname;
	}

	public String getPhone() {

		return this.phone;
	}

	public void setPhone(String phone) {

		this.phone = phone;
	}

	public String getEGN() {

		return this.egn;
	}

	public void setEGN(String egn) {

		this.egn = egn;
	}

	public int getRoles_id() {

		return this.roles_id;
	}

	public void setRoles_id(int roles_id) {

		this.roles_id = roles_id;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

}
