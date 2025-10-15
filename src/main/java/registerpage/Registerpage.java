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


@WebServlet("/Registerpage")
public class Registerpage extends HttpServlet {
	Connection con;
	Connection demo() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","jebamercy@0929");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (Connection con=demo()){
			
			
			PrintWriter pw=response.getWriter();				
			

	        Statement s = con.createStatement();
	        s.executeUpdate("CREATE TABLE IF NOT EXISTS studentsdata ("
	                + "student_name VARCHAR(30), "
	                + "student_pass VARCHAR(50), "
	                + "Email VARCHAR(50), "
	                + "Course VARCHAR(40))");

	        String n=request.getParameter("username");
			
			String pass=request.getParameter("password");
			String email=request.getParameter("email");
			String course=request.getParameter("course");
			PreparedStatement ps=con.prepareStatement("insert into studentsdata values(?,?,?,?)");
		
			 String checkQuery = "SELECT * FROM studentsdata WHERE Email = ?";
	         try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
	             checkStmt.setString(1, email);
	             try (ResultSet rs = checkStmt.executeQuery()) {
	                 if (rs.next()) {
	                     pw.println("<h3 style='color:red;'>Email already exists. Please try again.</h3>");
	                     RequestDispatcher dis = request.getRequestDispatcher("studentsdata.html");
	                     dis.include(request, response);
	                     return;
	                 }
	             }
	         }
	     	
				
				
				ps.setString(1,n);
				ps.setString(2,pass);
				ps.setString(3,email);
				ps.setString(4,course);
				int row=ps.executeUpdate();
			
			
			
			
			if(row>0 ) {
				response.sendRedirect("RegisterLoginpage.html");	
					 }else {
						 
						 pw.println("<h3 style='color:red;'>Registration failed. Try again.</h3>");
		                    RequestDispatcher dis = request.getRequestDispatcher("studentsdata.html");
		                    dis.include(request, response);
				
			}
		} 
		catch (SQLException | ClassNotFoundException e) {
			
		System.out.println(e);
		}
		
			
			
				}
	

		
		
	}

	

