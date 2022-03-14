package com.lxbordo.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lxbordo.todo.dao.TodoDaoImpl;
import com.lxbordo.todo.dao.UserDaoImpl;

@Controller
public class WelcomeController {

	@Autowired
	TodoDaoImpl todoimpl;

	@Autowired
	UserDaoImpl userdaoimpl;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {

		// User user = userdaoimpl.retrieveUserById(1);

		// Todos todo = new Todos(user.getId(), "Some description", new Date(), false,
		// new Date())


		return "welcome";
	}

}
