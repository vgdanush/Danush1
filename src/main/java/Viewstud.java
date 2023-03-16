

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Viewstud")
public class Viewstud extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='Regis.jsp'>Add New Employee</a>");
		out.println("<h1>Employee List</h1>");
		
		 List<encap> view=new ArrayList<encap>(); 
	        try{  
	            Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Danush@31");
	            PreparedStatement ps=con.prepareStatement("select * from employee");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                encap e=new encap();  
	                e.setId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setMobileno(rs.getString(5));
	                view.add(e);  
	            } 
	          System.out.println(view);
	            con.close(); 
	           
	        }
	     
	        catch(Exception e){e.printStackTrace();}  
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Mobileno</th><th>Edit</th><th>Delete</th></tr>");
		for(encap e:view){
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td>"+e.getMobileno()+"</td><td><a href='Updatestud?id="+e.getId()+"'>edit</a></td><td><a href='Delstud?id="+e.getId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
	}
