package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.model.OrderState;
import com.restaurant.model.User;
import com.restaurant.util.Database;

public class OrderStateDao {
	
	private Connection connection;

	public OrderStateDao() {
		connection = Database.getConnection();
	}
	
	
	
	
	public OrderState getOrderStateById(int id) {
		OrderState orderState = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from orderstate where id=?");
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				orderState = new OrderState();
				orderState.setState(rs.getString("state"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderState;
	}
}
