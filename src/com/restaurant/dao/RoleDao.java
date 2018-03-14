package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.restaurant.model.Role;
import com.restaurant.util.Database;

public class RoleDao {

	private Connection connection;

	public RoleDao() {
		connection = Database.getConnection();

	}

	public Role getRoleById(int role_id) {

		Role role = null;
		try {

			PreparedStatement preparedStatement = connection.prepareStatement("select * from role where id = ? ");
			preparedStatement.setInt(1, role_id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				role = new Role();
				role.setId(rs.getInt("id"));
				role.setRoleName(rs.getString("roleName"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return role;
	}

}
