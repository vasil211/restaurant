package com.restaurant.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.model.Table;

import com.restaurant.util.Database;

public class TableDao {

	private Connection connection;

	public TableDao() {
		connection = Database.getConnection();
	}

	public boolean addTable(Table table) { // chairCount
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into tables(chairCount) values (?)");

			preparedStatement.setInt(1, table.getChairCount());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public void deleteTable(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from tables where id=?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateTable(Table table) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update tables set chairCount=? " + "where tables.id= ?");

			preparedStatement.setInt(1, table.getChairCount());
			preparedStatement.setInt(2, table.getId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Table> getAllTables() {
		List<Table> tables = new ArrayList<Table>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM tables ");
			while (rs.next()) {
				Table table = new Table();

				table.setId(rs.getInt("id"));
				table.setChairCount(rs.getInt("chairCount"));
				tables.add(table);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tables;
	}

	public Table getTableById(String table_Id) {
		Table table = new Table();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from tables where tables.id=?");
			preparedStatement.setString(1, table_Id);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				table.setId(rs.getInt("id"));
				table.setChairCount(rs.getInt("chairCount"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return table;
	}

	public void checkTable(Table table) {
		try {
			PreparedStatement ps = connection.prepareStatement("select id from tables where id = ?");
			ps.setInt(1, table.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) // found
			{
				updateTable(table);
			} else {
				addTable(table);
			}
		} catch (Exception ex) {
			System.out.println("Error in check() -->" + ex.getMessage());
		}
	}

	public Table checkIfTableExist(int id, int chairCount) {
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from tables where tables.id = ? and tables.chairCount=?");
			ps.setInt(1, id);
			ps.setInt(2, chairCount);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Table table = new Table();
				table.setId(rs.getInt("id"));
				table.setChairCount(rs.getInt("chairCount"));
				return table;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
