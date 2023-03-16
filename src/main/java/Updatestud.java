

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Updatestud")
public class Updatestud extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	out.println("<h1>Update Student</h1>");
	String studid=request.getParameter("id");
	int id=Integer.parseInt(studid);
	encap e=new encap();
	try{  
		Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Danush@31");  
        PreparedStatement ps=con.prepareStatement("select * from employee where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery(); 
        
        if(rs.next()){  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setPassword(rs.getString(3));  
            e.setEmail(rs.getString(4));  
            e.setMobileno(rs.getString(5));
        }  
        con.close();  
    }catch(Exception ex){ex.printStackTrace();} 
	
	out.print("<form action='Updatestud1' method='post'>");
	out.print("<table>");
	out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
	out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
	out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
	out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
	out.print("<tr><td>Mobileno:</td><td><input type='text' name='mobileno' value='"+e.getMobileno()+"'/></td></tr>");
	out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
	out.print("</table>");
	out.print("</form>");
	
	out.close();
}

}
