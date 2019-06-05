package com.machinetest.dao;

import com.machinetest.model.UserLogin;

public interface UserDao {
	
	public int registerUser(UserLogin user);
	public String loginUser(UserLogin user);
}
