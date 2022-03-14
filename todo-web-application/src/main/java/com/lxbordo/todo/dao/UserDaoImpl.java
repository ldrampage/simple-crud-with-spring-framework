package com.lxbordo.todo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lxbordo.todo.model.User;

@Repository
public class UserDaoImpl {

	@Autowired
	JdbcTemplate jdbctemplate;

	public List<User> retrieveAllUsers() {
		List<User> result = null;
		result = jdbctemplate.query("select * from tbl_user", new BeanPropertyRowMapper<User>(User.class));
		return result;
	}
	
	public User retrieveUserById(int id) {
		User user = null;
		user = jdbctemplate.queryForObject("select * from tbl_user where id = ?",
				new BeanPropertyRowMapper<User>(User.class), new Object[] { id });
		return user;
	}

	public User retrieveUserByUsername(String username) {
		User user = null;
		try {
		user = jdbctemplate.queryForObject("select * from tbl_user where username = ?",
				new BeanPropertyRowMapper<User>(User.class), new Object[] { username.toLowerCase() });
		} catch (Exception ex) {

		}

		return user;
	}

}
