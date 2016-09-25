<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response</title>
</head>
<body>
        <jsp:useBean id="mybean" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="mybean" property="userId" />
        <h1>Hello, <jsp:getProperty name="mybean" property="userId" /> ! at  
         <%= new java.util.Date() %>
        </h1>
        
   <!--      <jsp:useBean id="mybean1" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="mybean" property="currencyFrom" />
        <h1><jsp:getProperty name="mybean" property="currencyFrom" /> </h1>
        
         <jsp:useBean id="data1" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="data1" property="currencyTo" />
        <h1><jsp:getProperty name="data1" property="currencyTo" /> </h1>
        
         <jsp:useBean id="data2" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="data2" property="amountSell" />
        <h1><jsp:getProperty name="data2" property="amountSell" /> </h1>
        
         <jsp:useBean id="data3" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="data3" property="amountBuy" />
        <h1><jsp:getProperty name="data3" property="amountBuy" /> </h1>
        
         <jsp:useBean id="data4" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="data4" property="rate" />
        <h1><jsp:getProperty name="data4" property="rate" /> </h1>
        
         <jsp:useBean id="data5" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="data5" property="timePlaced" />
        <h1><jsp:getProperty name="data5" property="timePlaced" /> </h1>
        
         <jsp:useBean id="data6" scope="session" class="com.currencyfair.CurrencyData" />
        <jsp:setProperty name="data6" property="originatingCountry" />
        <h1><jsp:getProperty name="data6" property="originatingCountry" /> </h1>
         -->
</body>
</html>