package com.lxbordo.todo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_todos")
public class Todos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int userId;

	@Column(name = "description")
	private String description;
	private Date targetDate;
	private String status;
	private Date insertedDate;

	public Todos() {
	}

	public Todos(int id, int userId, String desc, Date targetDate, String status) {
		this.id = id;
		this.userId = userId;
		this.description = desc;
		this.targetDate = targetDate;
		this.status = status;
	}

	public Todos(int userId, String desc, Date targetDate, String status, Date insertedDate) {
		this.userId = userId;
		this.description = desc;
		this.targetDate = targetDate;
		this.status = status;
		this.insertedDate = insertedDate;
	}

	public Todos(int id, int userId, String desc, Date targetDate, String status, Date insertedDate) {
		this.id = id;
		this.userId = userId;
		this.description = desc;
		this.targetDate = targetDate;
		this.status = status;
		this.insertedDate = insertedDate;
	}

	@Override
	public String toString() {
		return "Todos [id=" + id + ", userId=" + userId + ", desc=" + description + ", targetDate=" + targetDate
				+ ", isDone="
				+ status + ", insertedDate=" + insertedDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

}
