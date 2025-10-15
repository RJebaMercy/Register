package registerpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Loginpage")
public class Loginpage extends HttpServlet {
	Connection con;
	Connection demo() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","jebamercy@0929");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			con=demo();
			
			String n=request.getParameter("username");
			String p=request.getParameter("password");
			Integer pa=Integer.parseInt(p);
			
	
			if(!check(n,pa)) {
				pw.println("Enter valid user Name and Password");
				
	
				
					 }else {
//					RequestDispatcher dispantch =request.getRequestDispatcher("dash.html");
//					dispantch.forward(request, response);
						 response.sendRedirect("studentsdata");
				
			}
		} 
		catch (SQLException e) {
			
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			
			System.out.println(e);
		}
		}
	
	


	private boolean check(String n, Integer pa) throws SQLException {
		
		String q="select * from studentsdata where student_name=? and student_pass=?";
		PreparedStatement p=con.prepareStatement(q);
		p.setString(1, n);
		p.setInt(2, pa);
		ResultSet r=p.executeQuery();
		
		 
             return r.next();
         
	}
		
	}

	


