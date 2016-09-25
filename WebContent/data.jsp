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

            String id = request.getParameter("id");  

            ResultSet resultset = 
                statement.executeQuery("select * from CURRENCYFAIR where userId = '" + id + "'") ; 

            if(!resultset.next()) {
                out.println("Sorry, could not find that publisher. ");
            } else {
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
               <TD> <%= resultset.getDate(7) %> </TD>
               <TD> <%= resultset.getString(8) %> </TD>
           </TR>
       </TABLE>
       <BR>
       <% 
           } 
       %>
    </BODY>
</HTML>