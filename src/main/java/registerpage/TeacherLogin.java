package registerpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TeacherLogin")
public class TeacherLogin extends HttpServlet {
	Connection con;
	Connection demo() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","jebamercy@0929");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		try (Connection con=demo()){
			
			Statement s=con.createStatement();
			  s.executeUpdate("CREATE TABLE IF NOT EXISTS teachersdata ("
		                + "Teacher_name VARCHAR(30), "
		                + "Teacher_pass VARCHAR(50))");
			  String n=request.getParameter("tname");
				String p=request.getParameter("tpass");
			  PreparedStatement ps= con.prepareStatement("insert into teachersdata values(?,?)");
			  ps.setString(1, n);
			  ps.setString(2, p);
			  int row =ps.executeUpdate();
			  pw.println("welcome");
			  if(row>0 ) {
				  
					response.sendRedirect("studentdataentry.html");	
						 }else {
							 
							 pw.println("<h3 style='color:red;'>Registration failed. Try again.</h3>");
			                    RequestDispatcher dis = request.getRequestDispatcher("teacherlogin.html");
			                    dis.include(request, response);
					
				}
			  
		} catch (SQLException e) {
			
			System.out.println(e);
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
			
		}
		
	}

}
