package com.barosanu.emplapp.dbaccess;

import com.barosanu.emplapp.model.User;
import com.barosanu.emplapp.model.UserDetails;

public interface IDataBaseAccess {

	public UserDetails getUserDetails(User user);
	
	public UserDetails getUserDetails(String userId);
	
	public int getUserSalary(String userId);
	
	public int getUserSalaryHistory(String userId);

}
