package com.restaurant.dao;

import java.security.MessageDigest;
import java.sql.*;
import java.util.*;

import com.restaurant.model.Role;
import javax.xml.bind.DatatypeConverter;

import com.restaurant.model.User;
import com.restaurant.util.Database;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = Database.getConnection();
	}

	// public String validEmail(String email) {
	// try {
	//
	// String emailCh = "^[A-Za-z0-9-]+(\\[A-Za-z0-9])*@" +
	// "[A-Za-z0-9-]+(\\.[A-Za-z0-9])";
	//
	// if (email.equalsIgnoreCase(emailCh)) {
	// String chEmail = email;
	// System.out.println("email ch");
	// return chEmail;
	//
	// } else {
	//
	// System.out.println("Wrong Email");
	//
	// return null;
	//
	// }

	// } catch (Exception ex) {
	// System.out.println("Error in check() -->" + ex.getMessage());
	// }
	// System.out.println("email wrong");
	// return email;
	//
	// }

	public void checkUser(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement("select uname from users where uname = ?");
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
			PreparedStatement ps = connection.prepareStatement("select * from user where uname = ? and password = ?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUname(rs.getString("uname"));
//
				RoleDao roleDao = new RoleDao();
				int role_id = rs.getInt("role_id");
				Role role = roleDao.getRoleById(role_id);
				user.setRole(role);
				//
				return user;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean addUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into user(firstName,lastName,email,password,uname,phone,EGN,role_id) values (?, ?, ?, ?, ?, ?, ?, 2)");

			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getUname());
			preparedStatement.setString(6, user.getPhone());
			preparedStatement.setString(7, user.getEGN());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public String hash(String pass) {

		MessageDigest md;
		byte[] hash = null;
		try {
			md = MessageDigest.getInstance("MD5");
			hash = md.digest(pass.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(hash);
	}

	public void deleteUser(String user_Id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from user where uname=?");
			preparedStatement.setString(1, user_Id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update user set email=?, role_id=?, firstName= ?, lastName= ? " + "where uname= ?");

			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setInt(2, user.getRole().getId());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
			preparedStatement.setString(5, user.getUname());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		List<User> user = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from user "); // where role_id = 2
			while (rs.next()) {
				User users = new User();

				users.setUname(rs.getString("uname"));
				users.setFirstName(rs.getString("firstName"));
				users.setLastName(rs.getString("uname"));
				users.setPhone(rs.getString("phone"));
				users.setEGN(rs.getString("EGN"));
				users.setUname(rs.getString("uname"));
				users.setPassword(rs.getString("password"));
				users.setEmail(rs.getString("email"));
				users.setRegistration(rs.getDate("registration"));

				RoleDao roleDao = new RoleDao();
				int role_id = rs.getInt("role_id");
				Role role = roleDao.getRoleById(role_id);
				users.setRole(role);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public User getUserById(String user_Id) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where uname=?");
			preparedStatement.setString(1, user_Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setRegistration(rs.getDate("registration"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
}