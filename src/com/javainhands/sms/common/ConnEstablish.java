package com.javainhands.sms.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.javainhands.sms.constants.AppConstants;

public interface ConnEstablish {

	/**
	 * init method which establish the connection to the database for the whole
	 * class
	 * 
	 * @return established connection
	 * @throws SQLException
	 */
	static Connection init() throws SQLException {
		Connection connection = DriverManager.getConnection(AppConstants.URL, AppConstants.USER, AppConstants.PASSWORD);
		return connection;
	}
}
