package demoproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Demoproject")
public class Demoproject extends HttpServlet {
	
Connection con;
	
	void demo() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","jebamercy@0929");
		System.out.println("connnected");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("Hello....");
			demo();
			Statement s=con.createStatement();
			s.executeUpdate("create table if not exists servlet(pass int,uname varchar(10))");
			String n=request.getParameter("uname");
			String p=request.getParameter("pass");
			Integer pa=Integer.parseInt(p);
			PreparedStatement ps=con.prepareStatement("insert into servlet values(?,?)");
			ps.setInt(1,pa);
			ps.setString(2,n);
			ps.executeUpdate();
		
			
			
		} catch (SQLException | ClassNotFoundException e) {
			
			System.out.println(e);
		}
		
	
	
	}

}
