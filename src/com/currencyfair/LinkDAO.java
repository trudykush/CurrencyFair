package com.currencyfair;

//STEP 1. Import required packages
import java.sql.*;

public class LinkDAO {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@DELL:1521:XE";

   //  Database credentials
   static final String USER = "kushal";
   static final String PASS = "password";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("oracle.jdbc.driver.OracleDriver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT userId, currencyFrom, currencyTo, amountSell, amountBuy,"
      		+ "rate, timePlaced, originatingCountry FROM CURRENCYFAIR";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("userId");
         String cFrom = rs.getString("currencyFrom");
         String cTo = rs.getString("currencyTo");
         String aSell = rs.getString("amountSell");
         String aBuy = rs.getString("amountBuy");
         String rate = rs.getString("rate");
         String tPlaced = rs.getString("timePlaced");
         String oCountry = rs.getString("originatingCountry");

         //Display values
         System.out.print("id: " + id);
         System.out.print(", currencyFrom: " + cFrom);
         System.out.println(", currencyTo: " + cTo);
         System.out.print(", amountSell: " + aSell);
         System.out.println(", amountBuy: " + aBuy);
         System.out.print(", rate: " + rate);
         System.out.println(", timePlaced: " + tPlaced);
         System.out.println(", originatingCountry: " + oCountry);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main

public void save(String link, String source) {
	// TODO Auto-generated method stub
	
}
}//end FirstExample