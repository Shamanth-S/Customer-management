import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Index")
public class Index extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if ("test@sunbasedata.com".equals(id) && "Test@123".equals(password)) {
			response.sendRedirect("ViewCustomer");
		} else {
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Invalid Credentials</title>");
	        out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css'>"); // Include Bootstrap CSS
	        out.println("</head>");
	        out.println("<body class='bg-light'>"); // Apply Bootstrap class for light background

	        out.println("<div class='container text-center mt-5'>");
	        out.println("<h2 class='font-weight-bold'>Invalid credentials. Please try again.</h2>");
	        out.println("<a class='btn btn-primary mt-3' href='index.html' role='button'>Back to Login</a>");
	        out.println("</div>");

	        out.println("<script src='https://code.jquery.com/jquery-3.5.1.slim.min.js'></script>");
	        out.println("<script src='https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js'></script>");
	        out.println("<script src='https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js'></script>"); // Include Bootstrap JS
	        out.println("</body>");
	        out.println("</html>");
		}
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
