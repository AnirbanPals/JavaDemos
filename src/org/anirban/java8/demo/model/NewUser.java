package org.anirban.java8.demo.model;

public class NewUser extends User {

	private String name;
	private String email;

	public NewUser(String name, String email) {
		super(name);
		this.name = name;
		this.email = email;
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
}