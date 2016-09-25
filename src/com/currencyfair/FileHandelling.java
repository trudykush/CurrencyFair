package com.currencyfair;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileHandelling extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String link = request.getParameter("link");
	     String source = request.getParameter("source");
	     LinkDAO dao = new LinkDAO();
	     
	     dao.save(link, source);
	     
	     request.getRequestDispatcher("FrontEnd.jsp").forward(request, response);
	 }

}
