package com.bari.dao;

import java.sql.*;
import java.util.*;
import com.bari.model.User;
import com.bari.util.Database;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = Database.getConnection();
	}

	public void checkUser(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement("select Uname from users where Uname = ?");
			ps.setString(1, user.getUname());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) // found
			{
				updateUser(user);
			} else {
				addUser(user);
			}
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public User checkIfUserExist(String name, String pass) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from users where Uname = ? and Password = ?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUname(rs.getString("Uname"));
				user.setRoles_id(rs.getInt("roles_id"));
				return user;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public void addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into users(FirstName,LastName,Email,Password,Uname,Phone,EGN,,Roles_id,Registration) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getUname());
			preparedStatement.setInt(6, user.getPhone());
			preparedStatement.setInt(7, user.getEGN());
			preparedStatement.setInt(8, user.getRoles_id());
			preparedStatement.setDate(9, new java.sql.Date(user.getRegistration().getTime()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(String user_Id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where Uname=?");
			// Parameters start with 1
			preparedStatement.setString(1, user_Id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update users set Password=?, Email=?, Roles_id=?, Registration=?" + "where Uname=?");
			// Parameters start with 1
			System.out.println(new java.sql.Date(user.getRegistration().getTime()));
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, user.getRoles_id());
			preparedStatement.setDate(4, new java.sql.Date(user.getRegistration().getTime()));
			preparedStatement.setString(5, user.getUname());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				User user = new User();
				user.setUname(rs.getString("Uname"));
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email"));
				user.setRegistration(rs.getDate("Registration"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getUserById(String user_Id) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where Uname=?");
			preparedStatement.setString(1, user_Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUname(rs.getString("Uname"));
				user.setPassword(rs.getString("Password"));
				user.setEmail(rs.getString("Email"));
				user.setRegistration(rs.getDate("Registration"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}