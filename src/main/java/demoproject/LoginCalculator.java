package demoproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginCalculator")
public class LoginCalculator extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n=request.getParameter("uname");
		int p=Integer.parseInt(request.getParameter("pass"));
		PrintWriter pw=response.getWriter();
		if("Mercy".equals(n)) {
			response.sendRedirect("calculator.html");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			rd.include(request, response);
		
		}
		
		pw.println("Error");
		
	}

}
