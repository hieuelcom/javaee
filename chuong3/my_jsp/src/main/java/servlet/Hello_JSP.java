package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "Hello_JSP", urlPatterns = {"/Hello_JSP"})
public class Hello_JSP extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        out.println("<html>" + "<head><title>Hello World</title></head>" +
 "<body><h1>Hello World</h2><br>");
 out.println("Your IP address is " + request.getRemoteAddr());
        out.println("</body></html>");
        out.close();
    }
}
