

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		try {
			Connection con=DriverManager.getConnection("JDBC:MYSQL://LOCALHOST:3306/company","root","Danush@31");
			PreparedStatement pst=con.prepareStatement("Select * from admi where Username=? and Password=?");
			pst.setString(1,user);
			pst.setString(2,pass);
			
			ResultSet r=pst.executeQuery();
			if(r.next()) {
				response.sendRedirect("Viewstud");
				
			}
			else {
				response.sendRedirect("admin.jsp");	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
