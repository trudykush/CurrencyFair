package com.currencyfair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

import sun.util.calendar.BaseCalendar.Date;

public class CurrencyDAO {

	Connection conn = null;
	Statement stmt = null;

	public CurrencyDAO() {
		final String DB_URL = "jdbc:oracle:thin:@DELL:1521:XE";

		// Database credentials
		final String USER = "kushal";
		final String PASS = "password";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// STEP 3: Open a connection

	}

	public void insertData(CurrencyData[] currData) throws SQLException {

		int i = 0;

		stmt = conn.createStatement();
		ResultSet resultset = stmt.executeQuery("select * from CURRENCYFAIR");


		while(i < currData.length){

			String sql = "INSERT INTO CURRENCYFAIR " +
					"(userId, currencyFrom, currencyTo, amountSell, amountBuy, rate, timePlaced, originatingCountry)" +
					"VALUES (?,?,?,?,?,?,?,?)";

			String byUserId = currData[i].getUserId();
			//currData[i].setUserId(byUserId);
			String bycurrencyFrom = currData[i].getCurrencyFrom();
			String bycurrencyTo = currData[i].getCurrencyTo();
			Double byamountSell = currData[i].getAmountSell();
			Double byamountBuy = currData[i].getAmountBuy();
			Double byrate= currData[i].getRate();
			java.util.Date bytimePlaced = currData[i].getTimePlaced();
			String byoriginatingCountry = currData[i].getOriginatingCountry();
			Timestamp timeStamp = new Timestamp(currData[i].getTimePlaced().getTime());
			

			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, byUserId);
			preparedStatement.setString(2, bycurrencyFrom);
			preparedStatement.setString(3, bycurrencyTo);
			preparedStatement.setDouble(4, byamountSell);
			preparedStatement.setDouble(5, byamountBuy);
			preparedStatement.setDouble(6, byrate);
			preparedStatement.setTimestamp(7, timeStamp);
			preparedStatement.setString(8, byoriginatingCountry);
			preparedStatement.executeUpdate();
			
			//preparedStatement.setTimestamp(4, getCurrentTimeStamp());
			i++;

		}

	}

}
