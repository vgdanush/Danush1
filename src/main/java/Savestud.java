

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Savestud")
public class Savestud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String mobileno=request.getParameter("mobileno");
		
	    encap e=new encap ();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setMobileno(mobileno);
		
		try{  
            
          Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Danush@31");  
          PreparedStatement ps=con.prepareStatement( "insert into employee(name,password,email,mobileno) values (?,?,?,?)");  
     ps.setString(1,e.getName());  
     ps.setString(2,e.getPassword());  
     ps.setString(3,e.getEmail());  
     ps.setString(4,e.getMobileno());
       
     int status=ps.executeUpdate();  
     if(status>0){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("Regis.jsp").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
     
        }catch(Exception d){System.out.println(e);}  
		
	}

}
