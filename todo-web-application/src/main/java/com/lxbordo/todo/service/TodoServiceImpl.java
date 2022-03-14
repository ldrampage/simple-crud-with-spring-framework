package com.lxbordo.todo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxbordo.todo.dao.TodoDaoImpl;
import com.lxbordo.todo.model.Todos;

@Service
public class TodoServiceImpl {

	@Autowired
	private TodoDaoImpl tododaoimpl;

	public List<Todos> getTodosByUserId(int id) {
		return tododaoimpl.retrieveTodosByUserId(id);
	}

	public Todos getTodoById(int id) {
		return tododaoimpl.retrieveTodoById(id);
	}

	public boolean addTodoProcess(int userId, String desc, String targetDate, String status) {

		java.util.Date myDate = null;

		// targetDate
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			myDate = formatter.parse(targetDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		
		// inserted datetime
		// DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss.SSS");
		// java.util.Date inserted_date = new java.util.Date();

		Calendar cal = Calendar.getInstance();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
		
		return addTodo(new Todos(userId, desc, sqlDate, status, timestamp));
	}

	public boolean updateTodo(Todos todo) {
		return tododaoimpl.updateTodo(todo);
	}

	public java.sql.Date formatDate(String targetDate) {
		java.util.Date myDate = null;

		// targetDate
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			myDate = formatter.parse(targetDate);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new java.sql.Date(myDate.getTime());
	}

	public boolean deleteTodo(int todoId, int userId) {

		return tododaoimpl.deleteTodo(todoId, userId);

	}


	private boolean addTodo(Todos todo) {
		boolean result = false;
		result = tododaoimpl.addTodo(todo);
		return result;
	}



}
