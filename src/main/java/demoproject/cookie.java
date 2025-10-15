package demoproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie")
public class cookie extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	String n="mercy";

		PrintWriter pw=response.getWriter();
		Cookie ck =new Cookie("uname",n);
		ck.setMaxAge(60*2);
		pw.println("welcome"+n);
	
		
		
	}
}

	
