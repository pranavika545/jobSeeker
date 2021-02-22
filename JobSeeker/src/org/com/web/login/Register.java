package org.com.web.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.web.dao.DAO;
import org.com.web.model.User;


@SuppressWarnings("serial")
@WebServlet("/Register")
public class Register extends HttpServlet{

	private DAO db = new DAO();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User user = new User(	request.getParameter("firstName"), 
								request.getParameter("lastName"), 
								request.getParameter("email"), 
								request.getParameter("password"), 
								"Seeker");
		
		int i = 0;
		try {
			Connection conn = db.getConnection();
			Statement st=conn.createStatement();
			i=st.executeUpdate("insert into users(firstName, lastName, email, pass, role)"
									+ "values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getRole()+"')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (i==0) // no rows are affected
			response.getWriter().append("Error Creating");
		else
			response.sendRedirect("index.jsp");
	}

}
