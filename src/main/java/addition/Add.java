package addition;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Add")
public class Add extends HttpServlet {

  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		 
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String operation = request.getParameter("operation");
        PrintWriter pw=response.getWriter();

        double result = 0;

        
        if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
           

        	int number1=Integer.parseInt(num1);
        	int number2=Integer.parseInt(num1);
                

               
                if (operation.equals("ADD")) {
                    result = number1 + number2;
                } else if (operation.equals("SUB")) {
                    result = number1 - number2;
                } else if (operation.equals("MUL")) {
                    result = number1 * number2;
                } else if (operation.equals("DIV")) {
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        pw.println("Enter the valid number");
                    }
                }

               
                pw.println("Result: " + result );
            } 
		
		
	}

}
