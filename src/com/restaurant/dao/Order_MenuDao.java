package com.restaurant.dao;

import java.sql.Connection;

import com.restaurant.util.Database;

public class Order_MenuDao {
	private Connection connection;

public Order_MenuDao() {
	connection = Database.getConnection();
}
}


