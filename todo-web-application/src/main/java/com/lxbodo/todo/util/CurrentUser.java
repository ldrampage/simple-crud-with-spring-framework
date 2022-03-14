package com.lxbodo.todo.util;

public class CurrentUser {

	private static CurrentUser instance = new CurrentUser();
	private int id;
	private String name;
	private String userName;

	public static CurrentUser getIntance() {
		return instance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
