package com.restaurant.model;

import java.sql.Date;
import java.sql.Time;

public class Order {
<<<<<<< HEAD
	private int orderId;
	private Table table;
	private Time timeOfOrder;
	private Time timeOfCook;
	private Time timeOfPayment;
=======
	private Table table;
	private Time time;
>>>>>>> ac99de9924e1b835ae5d2147887c8f597fd36894
	private Date date;
	private User user;
	private OrderState orderState;

<<<<<<< HEAD
	public Time getTimeOfOrder() {
		return timeOfOrder;
	}

	public void setTimeOfOrder(Time timeOfOrder) {
		this.timeOfOrder = timeOfOrder;
=======
	public Table getTable() {
		return table;
	}

	public void setTable(Table tables) {
		this.table = tables;
>>>>>>> ac99de9924e1b835ae5d2147887c8f597fd36894
	}

	public Time getTimeOfCook() {
		return timeOfCook;
	}

	public void setTimeOfCook(Time timeOfCook) {
		this.timeOfCook = timeOfCook;
	}

	public Time getTimeOfPayment() {
		return timeOfPayment;
	}

	public void setTimeOfPayment(Time timeOfPayment) {
		this.timeOfPayment = timeOfPayment;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table tables) {
		this.table = tables;
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


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

}
