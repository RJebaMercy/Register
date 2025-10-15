package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registrationform")
public class Registrationform extends HttpServlet {
	Connection con;
	void demo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","jebamercy@0929");
	}
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	
		try {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			demo();
			Statement s=con.createStatement();
			s.executeUpdate("Create table if not exists login(uname varchar(10),pass int)");
			String n=request.getParameter("uname");
			String p=request.getParameter("pass");
			Integer pa=Integer.parseInt(p);
		PreparedStatement ps= con.prepareStatement("insert into login values(?,?)");
			ps.setString(1, n);
			ps.setInt(2, pa);
			int row=ps.executeUpdate();
			
			
	//pw.println(c.heck(n,pa));
			if(row>0) {
				pw.println("welcome "+n);
	//			ps.executeUpdate();
				
					 }else {
				pw.println("Enter valid user Name and Password");
			}
		} 
		catch (SQLException e) {
			
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			
			System.out.println(e);
		}
		}
	
	


	private boolean check(String n, Integer pa) throws SQLException {
		
		String q="select * from login where uname=? and pass=?";
		PreparedStatement p=con.prepareStatement(q);
		p.setString(1, n);
		p.setInt(2, pa);
		ResultSet r=p.executeQuery();
		
		 
             return r.next();
         
	}
}
	
	


