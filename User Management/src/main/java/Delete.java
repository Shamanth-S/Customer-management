import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Delete")
public class Delete extends HttpServlet{

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_new","root","root1234");
		
			
			ps = conn.prepareStatement("delete from login_new.customer where id = ?");
			ps.setString(1, id);
			row = ps.executeUpdate(); 
			
			response.sendRedirect("ViewCustomer");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			out.print(e);
		}
	}
}
