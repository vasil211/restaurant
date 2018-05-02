package com.restaurant.dao;

import java.sql.*;
import java.util.*;

import com.restaurant.model.Order;
import com.restaurant.model.OrderState;
import com.restaurant.model.Role;
import com.restaurant.model.Table;
import com.restaurant.model.User;
import com.restaurant.util.Database;

public class OrderDao {
	private Connection connection;

	public OrderDao() {
		connection = Database.getConnection();
	}

	public boolean addOrder(Order order) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into orders(table_id, timeOfOrder, timeOfCook, timeOfPaymet, date, user_id, orderState_id) values (?, ?, ?, ?, ?, ?, 1)");

			preparedStatement.setInt(1, order.getTable().getId());
			preparedStatement.setTime(2, order.getTimeOfOrder());
			preparedStatement.setTime(3, order.getTimeOfCook());
			preparedStatement.setTime(4, order.getTimeOfPayment());
			preparedStatement.setDate(5, order.getDate());
			preparedStatement.setInt(6, order.getUser().getId());
			preparedStatement.setInt(7, order.getOrderState().getId());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void updateOrder(Order order) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update orders set table_id=?, timeOfOrder=?, timeOfCook=?, timeOfPayment=?, user_id=?, orderState_id=?"
							+ "where id=?");
			preparedStatement.setInt(1, order.getTable().getId());
			preparedStatement.setTime(2, order.getTimeOfOrder());
			preparedStatement.setTime(3, order.getTimeOfCook());
			preparedStatement.setTime(4, order.getTimeOfPayment());
			preparedStatement.setInt(5, order.getUser().getId());
			preparedStatement.setInt(6, order.getOrderState().getId());
			preparedStatement.setInt(7, order.getOrderId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM restaurant.orders");
			while (rs.next()) {
				Order order = new Order();

				int tableId = rs.getInt("table_id");
				int user_id = rs.getInt("user_id");
			
				TableDao tableDao = new TableDao();
				Table table = tableDao.getTableById(tableId);
				UserDao userDao = new UserDao();
				User user = userDao.getUserById(user_id);
				order.setTable(table);
				order.setTimeOfOrder(rs.getTime("timeOfOrder"));
				order.setTimeOfCook(rs.getTime("timeOfCook"));
				order.setTimeOfPayment(rs.getTime("timeOfPayment"));
				order.setDate(rs.getDate("date"));
				order.setUser(user);
				order.getOrderState().setId(rs.getInt("orderState_id"));
				orders.add(order);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	public Order getOrder(int id) {
		Order order = null;
		try {
			PreparedStatement ps = connection.prepareStatement("select * from orders where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) // found
			{
				int userId = rs.getInt("user_id");
				int tableId = rs.getInt("table_id");
//				int orderStateId = rs.getInt("orderState_id");

				order = new Order();
				TableDao tableDao = new TableDao();
				Table table = tableDao.getTableById(tableId);
				UserDao userDao = new UserDao();
				User user = userDao.getUserById(userId);
//				OrderStateDao orderStateDao = new OrderStateDao();
//				OrderStateDao orderState = new OrderStateDao();

				order.setTable(table);
				order.setTimeOfOrder(rs.getTime("timeOfOrder"));
				order.setTimeOfCook(rs.getTime("timeOfCook"));
				order.setTimeOfPayment(rs.getTime("timeOfPayment"));
				order.setDate(rs.getDate("date"));
				order.setUser(user);
				order.getOrderState().setId(rs.getInt("orderState_id"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	public Order getOrderById(int orderId) {
		Order order = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where id=?");
			preparedStatement.setInt(1, orderId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				order = new Order();
				order.getTable().setId(rs.getInt("table_id"));
				order.setTimeOfOrder(rs.getTime("timeOfOrder"));
				order.setTimeOfCook(rs.getTime("timeOfCook"));
				order.setTimeOfPayment(rs.getTime("timeOfPayment"));
				order.setDate(rs.getDate("date"));
				order.getUser().setId(rs.getInt("user_id"));
				order.getOrderState().setId(rs.getInt("orderState_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}
}
