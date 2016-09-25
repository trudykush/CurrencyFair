<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<% Class.forName("oracle.jdbc.driver.OracleDriver"); %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
    <HEAD>
        <TITLE>Fetching Data From a Database</TITLE>
    </HEAD>

    <BODY>
        <H1>Fetching Data From a Database</H1>

        <% 
            Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@DELL:1521:XE", "kushal", "password");

            Statement statement = connection.createStatement();

            String id = request.getParameter("userId");
            


			String sql = "INSERT INTO CURRENCYFAIR " +
					"(userId, currencyFrom, currencyTo, amountSell, amountBuy, rate, timePlaced, originatingCountry)" +
					"VALUES (321548,INR,EUR,3215,632.4,0.4258,31-DEC-10 12:14:36,US)";

/*			String byUserId = currData[i].getUserId();
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
			
			*/	
            statement.executeUpdate(sql);
            
            ResultSet resultset = statement.executeQuery("select * from CURRENCYFAIR");

            while(resultset.next()){ 
        %>
        
        <TABLE BORDER="1">
             <TR>
               <TH>userId</TH>
               <TH>currencyFrom</TH>
               <TH>currencyTo</TH>
               <TH>amountSell</TH>
               <TH>amountBuy</TH>
               <TH>rate</TH>
               <TH>timePlaced</TH>
               <TH>originatingCountry</TH>
           </TR>
           <TR>
               <TD> <%= resultset.getString(1) %> </TD>
               <TD> <%= resultset.getString(2) %> </TD>
               <TD> <%= resultset.getString(3) %> </TD>
               <TD> <%= resultset.getString(4) %> </TD>
               <TD> <%= resultset.getString(5) %> </TD>
                <TD> <%= resultset.getString(6) %> </TD>
               <TD> <%= resultset.getString(7) %> </TD>
               <TD> <%= resultset.getString(8) %> </TD>
           </TR>
            </TABLE>
        <% 
            } 
        %>
        

    </BODY>
</HTML>