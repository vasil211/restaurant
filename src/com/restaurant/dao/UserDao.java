package com.restaurant.dao;

import java.security.MessageDigest;
import java.sql.*;
import java.util.*;
import javax.xml.bind.DatatypeConverter;

import com.restaurant.model.User;
import com.restaurant.util.Database;

public class UserDao {

	private Connection connection;

	public UserDao() {
		connection = Database.getConnection();
	}

	public String validEmail(String email) {
		try {

			String emailCh = "^[A-Za-z0-9-]+(\\[A-Za-z0-9])*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9])";

			if (email.equalsIgnoreCase(emailCh)) {
				String chEmail = email;
				System.out.println("email ch");
				return chEmail;

			} else {
				String wrongEmail = "";
				System.out.println(wrongEmail);

				return wrongEmail;

			}

		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
		System.out.println("email wrong");
		return email;

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
			PreparedStatement ps = connection.prepareStatement("select * from users where Uname = ? and Password = ?");
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

	public boolean addUser(User user) {  
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into users(FirstName,LastName,Email,Password,Uname,Phone,EGN,Roles_id) values (?, ?, ?, ?, ?, ?, ?, 2)");

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
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where Uname=?");
			preparedStatement.setString(1, user_Id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update users set Email=?, Roles_id=?, FirstName= ?, LastName= ? " + "where Uname= ?");

			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setInt(2, user.getRoles_id());
			preparedStatement.setString(3, user.getFirstName());
			preparedStatement.setString(4, user.getLastName());
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
			ResultSet rs = statement.executeQuery("select * from users order by ");
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