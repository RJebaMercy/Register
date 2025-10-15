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


@WebServlet("/StudentDataEntry")
public class StudentDataEntry extends HttpServlet {
	Connection con;
	Connection demo() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/loginform","root","jebamercy@0929");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		try (Connection con = demo()){
			Statement s = con.createStatement();
	        s.executeUpdate("CREATE TABLE IF NOT EXISTS Marks ("
	        		+"student_name varchar(30)"
	                + "Java VARCHAR(30), "
	                + "Python VARCHAR(50), "
	                + "Dotnet VARCHAR(50)");
	        String st=request.getParameter("stud");
	        String j=request.getParameter("java");
			String p=request.getParameter("python");
			String d=request.getParameter("dotnet");
			
			PreparedStatement ps=con.prepareStatement("insert into studentsdata values(?,?,?)");
			ps.setString(1,st);
			ps.setString(2,j);
			ps.setString(3,p);
			ps.setString(4,d);
			int row=ps.executeUpdate();
		
		
		
		
		if(row>0 ) {
//			response.sendRedirect("RegisterLoginpage.html");
			pw.println("welcome");
				 }else {
					 
//					 pw.println("<h3 style='color:red;'>Registration failed. Try again.</h3>");
//	                    RequestDispatcher dis = request.getRequestDispatcher("studentsdata.html");
//	                    dis.include(request, response);
			pw.println("invalid");
		}
			
		} 
		catch (SQLException e) {
			
			System.out.println(e);
	
	} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
	
	         
	}



}
