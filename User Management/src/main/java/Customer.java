import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Customer")
public class Customer extends HttpServlet{
	
	Connection conn;
	PreparedStatement ps;
	int row;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_new","root","root1234");
			
			String id = request.getParameter("id");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			ps = conn.prepareStatement("insert into login_new.customer(id, firstname, lastname, address, city, state, email, phone) values(?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, id);
			ps.setString(2, firstname);
			ps.setString(3, lastname);
			ps.setString(4, address);
			ps.setString(5, city);
			ps.setString(6, state);
			ps.setString(7, email);
			ps.setString(8, phone);
			row = ps.executeUpdate();
			
			response.sendRedirect("ViewCustomer");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			out.print(e);
		}
	}
}
