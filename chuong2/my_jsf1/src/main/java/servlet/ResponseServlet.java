/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@WebServlet(name = "ResponseServlet", urlPatterns = {"/ResponseServlet"})
public class ResponseServlet extends HttpServlet {

    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // then write the data of the response
        String username = request.getParameter("username");
        if ((username != null) && (username.length() > 0)) {
            out.println("<h2>Hello, " + username + "!</h2>");
        }
    }
}
