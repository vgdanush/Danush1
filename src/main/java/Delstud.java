

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Delstud")
public class Delstud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studid=request.getParameter("id");  
        int id=Integer.parseInt(studid);  
        try{  
        	Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Danush@31");  
            PreparedStatement ps=con.prepareStatement("delete from employee where id=?");  
            ps.setInt(1,id);  
            ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}   
        response.sendRedirect("Viewstud");  
    }  
}

