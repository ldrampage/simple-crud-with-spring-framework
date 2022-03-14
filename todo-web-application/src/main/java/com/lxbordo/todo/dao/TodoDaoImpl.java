package com.lxbordo.todo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lxbordo.todo.model.Todos;

@Repository
public class TodoDaoImpl {

	@Autowired
	JdbcTemplate jdbctemplate;

	public List<Todos> retrieveAllTodos() {
		List<Todos> result = null;
		result = jdbctemplate.query("select * from tbl_todos", new BeanPropertyRowMapper<Todos>(Todos.class));
		return result;
	}

	public List<Todos> retrieveTodosByUserId(int id) {
		List<Todos> result = null;
		result = jdbctemplate.query("select * from tbl_todos where user_id = ?",
				new BeanPropertyRowMapper<Todos>(Todos.class), new Object[] { id });
		return result;
	}

	public Todos retrieveTodoById(int id) {
		Todos result = null;
		result = jdbctemplate.queryForObject("select * from tbl_todos where id=?",
				new BeanPropertyRowMapper<Todos>(Todos.class), new Object[] { id });
		return result;
	}

	public boolean addTodo(Todos todo) {
		boolean result = false;
		int row = jdbctemplate.update(
				"insert into tbl_todos (user_id, description, target_date, status, inserted_date) "
						+ "values(?,?,?,?,?)",
				new Object[] { todo.getUserId(), todo.getDescription(), todo.getTargetDate(), todo.getStatus(),
						todo.getInsertedDate() });
		if (row > 0) {
			result = true;
		}
		return result;
	}

	public boolean updateTodo(Todos todo) {
		boolean result = false;
		int row = jdbctemplate.update(
				"update tbl_todos set description = ?, target_date = ?, status = ? where user_id = ? and id = ?",
				new Object[] { todo.getDescription(), todo.getTargetDate(), todo.getStatus(), todo.getUserId(),
						todo.getId() });
		if (row > 0) {
			result = true;
		}
		return result;
	}

	public boolean deleteTodo(int todoId, int userId) {
		boolean result = false;

		int row = jdbctemplate.update("delete from tbl_todos where id = ? and user_id = ?",
				new Object[] { todoId, userId });
		if (row > 0) {
			result = true;
		}
		return result;
	}

}
