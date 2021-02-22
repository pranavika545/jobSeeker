package org.com.web.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.web.dao.DAO;
import org.com.web.model.User;


@SuppressWarnings("serial")
@WebServlet("/Admin")
public class Admin extends HttpServlet 
{
	private DAO db = new DAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		try{
			Connection con = db.getConnection();
			Statement st= con.createStatement();
			if(req.getParameter("action").equals("edit"))
			{
				ResultSet rs=st.executeQuery("select * from users where email='"+req.getParameter("email")+"'");
				rs.next();
				User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				req.setAttribute("u", user);
				req.getRequestDispatcher("Update.jsp").forward(req, resp);
			}
			else
			{
				st.executeUpdate("delete from users where email='"+req.getParameter("email")+"'");
				req.setAttribute("userList", getUsers());
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
				System.out.println("Deleted");
			}
			
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		try{
			Connection con = db.getConnection();
			Statement st= con.createStatement();
			st.executeUpdate("update users set "
								+ "firstName = '"+req.getParameter("firstName")
								+"', lastName = '"+req.getParameter("lastName")
								+"' where email= '"+req.getParameter("email")+"'");
			
			req.setAttribute("userList", getUsers());
			req.getRequestDispatcher("admin.jsp").forward(req, resp);
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		
	}
	
	public List<User> getUsers()
	{
		List<User> users = new ArrayList<>();
		try {
			Connection con = db.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users");
			
			while(rs.next())
			{
				users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
