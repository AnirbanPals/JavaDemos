package org.anirban.java8.demo.model;

public class User {

	private final String login;
	
	private final Role role;
	
	public static enum Role {
		Viewer, Editor, Admin
	}

	public User() {
		super();
		login = "user";
		role = Role.Viewer;
	}

	public User(String user) {
		super();
		this.login = user;
		role = Role.Viewer;
	}

	public User(String login, Role role) {
		this.login = login;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public Role getRole() {
		return role;
	}
}