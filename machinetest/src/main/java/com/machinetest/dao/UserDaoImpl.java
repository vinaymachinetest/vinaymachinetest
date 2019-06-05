package com.machinetest.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.machinetest.model.UserLogin;

public class UserDaoImpl implements UserDao {
	
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSoruce) {
		jdbcTemplate = new JdbcTemplate(dataSoruce);
	}

	public int registerUser(UserLogin user) {
		
		String sql = "INSERT INTO USER_DATA VALUES(?,?)";

		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { user.getUserId(), user.getPassword() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}	
	public String loginUser(UserLogin user) {
		
		String sql = "SELECT USER_ID FROM USER_DATA WHERE USER_ID=? AND USER_PASS=?";
		
		try {

			String userId = jdbcTemplate.queryForObject(sql, new Object[] {
					user.getUserId(), user.getPassword() }, String.class);

			return userId;
			
		} catch (Exception e) {
			return null;
		}
	}

}
