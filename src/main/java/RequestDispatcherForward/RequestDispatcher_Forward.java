package RequestDispatcherForward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDispatcher_Forward
 */
@WebServlet("/RequestDispatcher_Forward")
public class RequestDispatcher_Forward extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n=request.getParameter("uname");
		String p=request.getParameter("pass");
		Integer pa=Integer.parseInt(p);
		PrintWriter pw=response.getWriter();
		
		
		
		if("admin".equalsIgnoreCase(n) && pa==1234) {
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
//			else {
//			
//			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
//			
//			rd.include(request, response);
//		}
		else {
			response.sendRedirect("calculator.html");
			
		}
		pw.println("error");
	}

}
