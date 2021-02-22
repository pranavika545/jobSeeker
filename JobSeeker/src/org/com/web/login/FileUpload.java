package org.com.web.login;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.com.web.dao.DAO;
import org.com.web.model.User;


@SuppressWarnings("serial")
@WebServlet("/uploadFile")
@MultipartConfig
public class FileUpload extends HttpServlet 
{
	private DAO db = new DAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    
	    ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
	    
		try {
			List<FileItem> items = sfu.parseRequest(request);
			    for(FileItem item : items)
			    {
					item.write(new File("C:\\Users\\Reddy\\Desktop\\"+item.getName()));
			    }
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = db.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from users where email = '"+request.getParameter("email")+"'");
			
			rs.next();
			User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			request.setAttribute("u", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    
        request.getRequestDispatcher("user.jsp").forward(request, response);
	}

}
