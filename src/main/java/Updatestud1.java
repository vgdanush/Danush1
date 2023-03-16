

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Updatestud1")
public class Updatestud1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String studid=request.getParameter("id");
		int id=Integer.parseInt(studid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		
		encap e=new encap();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setMobileno(mobileno);
		try{  
			Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Danush@31");  
            PreparedStatement ps=con.prepareStatement(  
                         "update employee set name=?,password=?,email=?,mobileno=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getMobileno()); 
            ps.setInt(5,e.getId());  
              
            int status=ps.executeUpdate();  
              
            con.close();  
        
		
		
		if(status>0){
			response.sendRedirect("Viewstud");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
		}catch(Exception ex){
			ex.printStackTrace();} 
	}

}
