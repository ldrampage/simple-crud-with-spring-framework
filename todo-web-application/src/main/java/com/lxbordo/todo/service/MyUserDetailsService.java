package com.lxbordo.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lxbodo.todo.util.CurrentUser;
import com.lxbordo.todo.dao.UserDaoImpl;
import com.lxbordo.todo.model.User;
import com.lxbordo.todo.security.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDaoImpl.retrieveUserByUsername(username);

		if (user == null) {
			System.out.println("username not found");
			throw new UsernameNotFoundException("username not found!");
		} else {

			CurrentUser.getIntance().setId(user.getId());
			CurrentUser.getIntance().setName(user.getName());
			CurrentUser.getIntance().setUserName(user.getUsername());

			return new MyUserDetails(user);

		}




	}

}
