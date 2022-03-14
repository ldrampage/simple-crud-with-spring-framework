package com.lxbordo.todo.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxbodo.todo.util.CurrentUser;
import com.lxbordo.todo.model.Todos;
import com.lxbordo.todo.service.TodoServiceImpl;

@Controller
public class TodosController {

	@Autowired
	private TodoServiceImpl todoserviceimpl;


	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String showTodosListPage(ModelMap model) {
		model.addAttribute("todos", todoserviceimpl.getTodosByUserId(CurrentUser.getIntance().getId()));
		return "list-todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodo() {
		return "add-todo";
	}

	@RequestMapping(value = "/add-todo-form", method = RequestMethod.POST)
	public String addTodo(@RequestParam String description, @RequestParam String targetDate,
			@RequestParam String status) throws ParseException {
		todoserviceimpl.addTodoProcess(CurrentUser.getIntance().getId(), description, targetDate, status);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todos todo = todoserviceimpl.getTodoById(id);
		String[] statuses = new String[] { "in-progress", "on-hold", "completed" };
		model.addAttribute("id", todo.getId());
		model.addAttribute("description", todo.getDescription());
		model.addAttribute("targetDate", todo.getTargetDate());
		model.addAttribute("statuses", statuses);
		model.addAttribute("status", todo.getStatus());
		// model.clear();
		return "update-todo";
	}

	@RequestMapping(value = "/update-todo-form", method = RequestMethod.POST)
	public String updateTodoForm(@RequestParam int id, @RequestParam String description
			, @RequestParam String targetDate, @RequestParam String status) {
		boolean result = todoserviceimpl
				.updateTodo(new Todos(id, CurrentUser.getIntance().getId(), description,
						todoserviceimpl.formatDate(targetDate), status));
		System.out.println(result);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String showDeleteTodoPage(@RequestParam int id) {
		todoserviceimpl.deleteTodo(id, CurrentUser.getIntance().getId());
		return "redirect:list-todos";
	}

}
