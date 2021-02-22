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
import javax.servlet.http.HttpSession;

import org.com.web.dao.DAO;
import org.com.web.model.User;


@SuppressWarnings("serial")
@WebServlet("/SeekerLogin")
public class SeekerLogin extends HttpServlet {
	
	private DAO db = new DAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		
		try{
			Connection con = db.getConnection();
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from users where email='"+email+"' and pass='"+pass+"'");
			rs.next();
			User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			if(rs.getString("pass").equals(pass)&&rs.getString("email").equals(email))
			{
				if(rs.getString(5).equals("Seeker"))
				{
					HttpSession session = request.getSession(); 
					session.setAttribute("user", rs.getString("firstName")+" "+rs.getString("lastName"));
					request.setAttribute("u", user);
					request.getRequestDispatcher("user.jsp").forward(request, response);
				}
				else if(rs.getString(5).equals("Admin"))
				{
					HttpSession session = request.getSession(); 
					session.setAttribute("user", rs.getString("firstName")+" "+rs.getString("lastName"));
					ResultSet userList = st.executeQuery("select * from users");
					List<User> users = this.getUsers(userList);
					request.setAttribute("userList", users);
					request.getRequestDispatcher("admin.jsp").forward(request, response);
				}
			}
			else
			{
				response.getWriter().append("Invalid password or username.");
			}
		}
		catch (Exception e) {
		e.printStackTrace();
		}

	}

	private List<User> getUsers(ResultSet rs) throws SQLException {
		List<User> users = new ArrayList<>();
		while(rs.next())
		{
			users.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		return users;
	}

}
