package com.barosanu.emplapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.barosanu.emplapp.dbaccess.IDataBaseAccess;
import com.barosanu.emplapp.model.User;
import com.barosanu.emplapp.model.UserDetails;
import com.barosanu.emplapp.model.WorkingPossition;

public class Project {

	private IDataBaseAccess dataBaseAccess;

	private String name;
	private List<User> users;

	public Project(String name, IDataBaseAccess dataBaseAccess) {
		this.setName(name);
		this.users = new ArrayList<User>();
		this.dataBaseAccess = dataBaseAccess;
	}

	public UserDetails getUserDetails(User user) {
		return dataBaseAccess.getUserDetails(user);
	}

	public void addUser(User user) {
		this.users.add(user);
	};

	public void addUsers(User... users) {
		this.users.addAll(Arrays.asList(users));
	}

	public List<User> getUsers() {
		return users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsersWithPossition(WorkingPossition workingPossition) {
		List<User> returnedUsers = new ArrayList<User>();
		for (User user : users) {
			if (user.getWorkingPossition().equals(workingPossition))
				returnedUsers.add(user);
		}
		return returnedUsers;
	}

}
