package com.restaurant.model;

import java.sql.Date;
import java.sql.Time;

public class Order {
	private Table table;
	private Time time;
	private Date date;
	private User user;
	private OrderState orderState;

	public Table getTable() {
		return table;
	}

	public void setTable(Table tables) {
		this.table = tables;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

}
