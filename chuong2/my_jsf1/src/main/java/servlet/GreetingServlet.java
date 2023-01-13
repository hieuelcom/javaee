/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "GreetingServlet", urlPatterns = {"/GreetingServlet"})
public class GreetingServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        // then write the data of the response
        out.println("<html>" + "<head><title>Hello</title></head>");
        // then write the data of the response
        out.println(
                "<body bgcolor=\"#ffffff\">"
                + "<h2>Hello, my name is Duke. What's yours?</h2>"
                + "<form method=\"get\" >"
                //+ "<form method=\"get\" action=\"/hello_servlet/response\">"
                + "<input type=\"text\" name=\"username\" size=\"25\">"
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
                + "<input type=\"reset\" value=\"Reset\">" + "</form>");
        String username = request.getParameter("username");
        if ((username != null) && (username.length() > 0)) {
            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(
                            "/response");
            if (dispatcher != null) {
                dispatcher.include(request, response);
            }
        }
        out.println("</body></html>");
        out.close();
    }

    public void init() throws ServletException {
        System.out.println("--> GreetingServlet.init()...");
    }

    public void destroy() {
        System.out.println("--> GreetingServlet.destroy()...");
    }
}
