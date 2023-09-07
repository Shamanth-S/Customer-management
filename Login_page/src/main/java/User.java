import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/customers")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Handle creating, updating, and deleting customers API calls here
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Handle getting the customer list API call here
    }
}
