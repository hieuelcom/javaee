/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class SessionTrack extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        if (request.getParameter("reset") != null) {
            session.invalidate();
            session = request.getSession(true);
        }
        // Get session creation time.
        Date createTime = new Date(session.getCreationTime());
        // Get last access time of this web page.
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        String uName = request.getParameter("username");
        String userName = "";
        String userNameKey = "userNameKey";

        if ((uName != null) && (uName.length() > 0)) {
            System.out.println("Putting user name: " + uName + " to session data...");
            session.setAttribute(userNameKey, uName);
        }

        // Check if this is new comer on your web page.
        String title = "Welcome Back to my website";
        if (session.isNew()) {
            title = "Welcome to my website";
        } else {
            userName = (String) session.getAttribute(userNameKey);
            System.out.println("Got user name: " + userName + " from session data...");
            title = "<b>Welcome Back to my website</b><br>"
                    + "Session create time: " + createTime.toString() + "<br>"
                    + "Session last access: " + lastAccessTime.toString() + "<br>"
                    + "Stored user in session data: " + userName + "<p>-----<br>"
                    + "Please enter new user:";
        }
        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();
        // then write the data of the response
        out.println("<html>" + "<head><title>Hello</title></head>");
        // then write the data of the response
        out.println(
                "<body bgcolor=\"#ffffff\">" + title
                + "<form method=\"get\" >"
                //+ "<form method=\"get\" action=\"/hello_servlet/response\">"
                + "<input type=\"text\" name=\"username\" size=\"25\" value=\"" + userName
                + "\">"
                + "<p></p>" + "<input type=\"submit\" value=\"Submit\">"
                + "</form>");
        out.println(
                "<form method=\"get\" >"
                + "<input type=\"hidden\" + name=\"reset\" + value=\"true\" >"
                //+ "<form method=\"get\" action=\"/hello_servlet/response\">"
                + "<input type=\"submit\" value=\"Reset Session\">" + "</form>");
        out.println("</body></html>");
        out.close();
    }
}