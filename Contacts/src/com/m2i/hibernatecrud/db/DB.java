package com.m2i.hibernatecrud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private static final String HOST = "localhost";
	private static final String DBNAME = "schema_contacts";
	private static final Integer PORT = 3306;
	
	private static final String USERNAME = "user_hibernate";
	private static final String PASSWORD = "hibernate";
	
	public DB() {
	}

	private static void loadDriver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String urlConnect() {
		return "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}
	
	private static Connection establishConnection() throws SQLException {
		return DriverManager.getConnection(urlConnect(), USERNAME, PASSWORD);
	}
	
	private static Statement getStatement() throws SQLException {
		loadDriver();
		return establishConnection().createStatement();
	}
	
	public static Integer executeInsert(String query) throws SQLException {
		return getStatement().executeUpdate(query);
	}
	
	public static ResultSet executeSelect(String query) throws SQLException {
		return getStatement().executeQuery(query);
	}
	
	public static Boolean executeDelete(String query) throws SQLException {
		return (getStatement().executeUpdate(query) > 0);
	}
	
	public static String parseToSql(String str) {
		return "'" + str.replace("'", "\\'") + "'";
	}
}
