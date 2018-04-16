package com.restaurant.dao;

import java.sql.*;
import java.util.*;
import com.restaurant.model.Menu;
import com.restaurant.util.Database;

public class MenuDao {
	private Connection connection;

	public MenuDao() {
		connection = Database.getConnection();
	}

	public void checkFood(Menu menu) {
		try {
			PreparedStatement ps = connection.prepareStatement("select name from user where name = ?");
			ps.setString(1, menu.getName());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) // found
			{
				updateFood(menu);
			} else {
				addFood(menu);
			}
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public Menu checkIfFoodExist(String name, String foodType) {
		try {
			PreparedStatement ps = connection.prepareStatement("select * from menu where name = ? and foodType = ?");
			ps.setString(1, name);
			ps.setString(2, foodType);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Menu menu = new Menu();
				menu.setName(rs.getString("uname"));
				menu.setFoodType(rs.getString("foodType"));
				return menu;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean addFood(Menu menu) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into menu(name,foodType,description,price) values (?, ?, ?, ?)");

			preparedStatement.setString(1, menu.getName());
			preparedStatement.setString(2, menu.getFoodType());
			preparedStatement.setString(3, menu.getDescription());
			preparedStatement.setDouble(4, menu.getPrice());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void deleteFood(int menu_Id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from menu where name=?");
			preparedStatement.setInt(1, menu_Id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFood(Menu menu) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update menu set name=?, foodType=?, description= ?, price= ? " + "where name= ?");

			preparedStatement.setString(1, menu.getName());
			preparedStatement.setString(2, menu.getFoodType());
			preparedStatement.setString(3, menu.getDescription());
			preparedStatement.setDouble(4, menu.getPrice());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Menu> getAllFood() {
		List<Menu> menu = new ArrayList<Menu>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from menu");
			while (rs.next()) {
				Menu menu1 = new Menu();
				menu1.setName(rs.getString("name"));
				menu1.setFoodType(rs.getString("foodType"));
				menu1.setDescription(rs.getString("description"));
				menu1.setPrice(rs.getDouble("price"));
				menu.add(menu1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}

	public Menu getFoodByID(int menu_Id) {
		Menu menu = new Menu();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where name=?");
			preparedStatement.setInt(1, menu_Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				menu.setName(rs.getString("name"));
				menu.setFoodType(rs.getString("foodType"));
				menu.setDescription(rs.getString("description"));
				menu.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menu;
	}

}
