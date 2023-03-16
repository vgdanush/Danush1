

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
			Connection con;
			try {
				con = DriverManager.getConnection("JDBC:MYSQL://LOCALHOST:3306/company","root","Danush@31");
				PreparedStatement pst=con.prepareStatement("update login set Password=? where Username=?");
		       pst.setString(1, pass);
		       pst.setString(2, user);
		       
		       int rows=pst.executeUpdate();
		       System.out.println("rows affected "+rows);
		       if(rows>0) {
		       response.getWriter().println("Update Successfully");
		       }
		       else {
		    	   response.getWriter().println("Update not Successfully");
		       }
		       con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
