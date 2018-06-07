package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.model.Menu;
import com.restaurant.model.Order_Menu;
import com.restaurant.util.Database;

public class Order_MenuDao {
	private Connection connection;

public Order_MenuDao() {
	connection = Database.getConnection();
}



  public Order_Menu getFoodByOrderId(int orders_id) {
	  
	  Order_Menu order_menu = new Order_Menu();
	  try {
		  PreparedStatement preparedStatement = connection.prepareStatement("select * from menu_orders where orders_id=?");
			preparedStatement.setInt(1, orders_id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
		order_menu.getMenu().setId((rs.getInt("menu_id")));        
	  
			}
  }catch (SQLException e) {
		e.printStackTrace();
	}
	  return order_menu;
  }

  public Order_Menu getFoodNameById(int menu_Id) {
	  Order_Menu order_menu = new Order_Menu();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from menu where id=?");
			preparedStatement.setInt(1, menu_Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				order_menu.getMenu().setName("name");       
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order_menu;
	}
}