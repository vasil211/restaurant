package com.restaurant.dao;

import java.sql.*;
import java.util.*;

import com.restaurant.model.Order;
import com.restaurant.model.Role;
import com.restaurant.model.User;
import com.restaurant.util.Database;

public class OrderDao {
	private Connection connection;

	public OrderDao() {
		connection = Database.getConnection();
	}

//	public boolean addOrder(Order order) {
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(
//					"insert into orders(table_id,time,date,user_id,orderState_id) values (?, ?, ?, ?, 1)");
//
//			preparedStatement.setTable(1, order.getTable());
//			preparedStatement.setTime(2, order.getTime());
//			preparedStatement.setDate(3, order.getDate());
//			preparedStatement.setUser(4, order.getUser());
//			preparedStatement.setOrderState(5, order.getOrderState());
//			preparedStatement.executeUpdate();
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		}
//
//	}
//
//	public void updateOrder(Order order) {
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("update orders set orderState_id=?" + "where user_id= ? and .......");
//			// kak da updeina onikalen order
//
//			preparedStatement.setOrderState(1, order.getOrderState());
//			preparedStatement.setUser(2, order.getUser());
//			preparedStatement.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public List<Order> getAllOrders() {
//		List<Order> orders = new ArrayList<Order>();
//		try {
//			Statement statement = connection.createStatement();
//			ResultSet rs = statement.executeQuery("SELECT * FROM restaurant.orders");
//			while (rs.next()) {
//				Order order = new Order();
//
//				order.setTable(rs.getTable("table_id"));
//				order.setTime(rs.getTime("time"));
//				order.setDate(rs.getDate("date"));
//				order.setUser(rs.getUser("user_id"));
//				order.setOrderState(rs.getOrderState("orderState_id"));
//				orders.add(order);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return orders;
//	}
//
//	public Order getOrder(Order order) {//KAK????????????????????
//		Order order1 = new Order();
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where time=? date=?");
//			preparedStatement.setTime(1, time);
//			preparedStatement.setDate(2, date);
//			ResultSet rs = preparedStatement.executeQuery();
//
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return order1;
//	}
}
