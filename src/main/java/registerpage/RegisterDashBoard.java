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

@WebServlet("/RegisterDashBoard")
public class RegisterDashBoard extends HttpServlet {
    Connection con;

    Connection demo() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/loginform","root","jebamercy@0929");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	PrintWriter pw=response.getWriter();
    	
        String n = request.getParameter("username");
        String pass = request.getParameter("password");

        if (n == null || pass == null || n.isEmpty() || pass.isEmpty()) {
            response.getWriter().println("Please provide username and password");
            return;
        }

        try (Connection con = demo()) {
            String sql = "SELECT * FROM studentsdata WHERE student_name=? AND student_pass=?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, n);
                ps.setString(2, pass);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        
                        request.setAttribute("Name", rs.getString("student_name"));
                        request.setAttribute("Email", rs.getString("Email"));
                        request.setAttribute("Course", rs.getString("Course"));

                        
                        RequestDispatcher dispatcher = request.getRequestDispatcher("dash.jsp");
                        dispatcher.forward(request, response);
                        
                    } else {
                        response.getWriter().println("Invalid username or password");
                    }
                  
                }
                
            }
//           pw.println("<a href='logout.java'>Logout</a>"); 
//            pw.println("<center>");
         
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


