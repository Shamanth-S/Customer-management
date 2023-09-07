import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class Edit extends HttpServlet {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int row;

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_new", "root", "root1234");

            ps = conn.prepareStatement("select * from login_new.customer where id = ?");
            ps.setString(1, id);

            rs = ps.executeQuery();

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit Customer</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">");
            out.println("<style>");
            out.println(".container { text-align: center; margin-top: 50px; }");
            out.println("td:first-child { background-color: black; color: white; }");
            out.println("td:nth-child(2) { background-color: #ccc; }");
            out.println("td b { font-weight: bold; }");
            out.println("h1 { color: black; font-weight: bold; }"); // Added style for h1
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");

            out.println("<h1>Details</h1>"); // Added h1 element

            while (rs.next()) {
                out.println("<form action='EditDetails' method='POST'>");
                out.println("<table class='table table-bordered mx-auto' style='width: 50%;'>");
                out.println("<tr><td><b>id : </b></td><td><input type='text' class='form-control' name='id' id='id' value='" + rs.getString("id") + "'/></td></tr>");
                out.println("<tr><td><b>First Name : </b></td><td><input type='text' class='form-control' name='firstname' id='firstname' value='" + rs.getString("firstname") + "'/></td></tr>");
                out.println("<tr><td><b>Last Name : </b></td><td><input type='text' class='form-control' name='lastname' id='lastname' value='" + rs.getString("lastname") + "'/></td></tr>");
                out.println("<tr><td><b>Address : </b></td><td><input type='text' class='form-control' name='address' id='address' value='" + rs.getString("address") + "'/></td></tr>");
                out.println("<tr><td><b>City : </b></td><td><input type='text' class='form-control' name='city' id='city' value='" + rs.getString("city") + "'/></td></tr>");
                out.println("<tr><td><b>State : </b></td><td><input type='text' class='form-control' name='state' id='state' value='" + rs.getString("state") + "'/></td></tr>");
                out.println("<tr><td><b>Email : </b></td><td><input type='text' class='form-control' name='email' id='email' value='" + rs.getString("email") + "'/></td></tr>");
                out.println("<tr><td><b>Phone : </b></td><td><input type='text' class='form-control' name='phone' id='phone' value='" + rs.getString("phone") + "'/></td></tr>");
                out.println("</table><br>");
                out.println("<input type='submit' class='btn btn-primary' value='Edit'/>");
                out.println("</form>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.print(e);
        }
    }
}
