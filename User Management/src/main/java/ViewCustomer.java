import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewCustomer")
public class ViewCustomer extends HttpServlet{
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_new","root","root1234");
			
			String query = "select * from login_new.customer";
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			out.println("<html>");
            out.println("<head>");
            out.println("<title>User Management</title>");
            out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>");
            out.println("<style>");
            out.println("body { background-color: #ccc; }");
            out.println("div.content { display: flex; flex-direction: column; align-items: center; text-align: center; }");
            out.println("div.table-container { width: 70%; }");
            out.println("table th { background-color: #000000; color: white; }");
            out.println("table td { background-color: white; }"); 
            out.println("button { margin-top: 10px; }");
            out.println("h1 { color: black; }"); 
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='content'>");
            out.println("<h1>Customer List</h1>"); 
            out.println("<hr>");
            out.println("<div class='table-container'>");
            out.println("<table class='table table-striped table-bordered'>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>First Name</th>");
            out.println("<th>Last Name</th>");
            out.println("<th>Address</th>");
            out.println("<th>City</th>");
            out.println("<th>State</th>");
            out.println("<th>Email</th>");
            out.println("<th>Phone</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");

            while (rs.next()) {

                out.println("<tr>");
                out.println("<td>" + rs.getString("id") + "</td>");
                out.println("<td>" + rs.getString("firstname") + "</td>");
                out.println("<td>" + rs.getString("lastname") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("city") + "</td>");
                out.println("<td>" + rs.getString("state") + "</td>");
                out.println("<td>" + rs.getString("email") + "</td>");
                out.println("<td>" + rs.getString("phone") + "</td>");

                out.println("<td>");
                out.println("<a class='btn btn-info' href='Edit?id=" + rs.getString("id") + "'>Edit</a>");
                out.println("<a class='btn btn-danger' href='Delete?id=" + rs.getString("id") + "'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</div>");

            out.println("<button class='btn btn-primary'><a href='add.html' style='color: white;'>Add Customer</a></button>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");	
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			out.print(e);
		}
	}
}
