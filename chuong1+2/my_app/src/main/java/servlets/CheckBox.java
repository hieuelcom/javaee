package servlets;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

public class CheckBox extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title = "Reading Checkbox Data";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";
        out.println(docType
                + "<html>\n" + "<head><title>" + title + "</title></head>\n"
                + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + title + "</h1>\n" + "<ul>\n"
                + " <li><b>Maths Flag : </b>: "
                + request.getParameter("maths") + "\n"
                + " <li><b>Physics Flag: </b>: "
                + request.getParameter("physics") + "\n"
                + " <li><b>Chemistry Flag: </b>: "
                + request.getParameter("chemistry") + "\n"
                + "</ul>\n"
                + "</body></html>");
        Enumeration headerNames = request.getHeaderNames();
        out.print("<table width=\"100%\" border=\"1\" align=\"center\">\n"
                + "<tr bgcolor=\"#949494\">\n"
                + "<th>Header Name</th><th>Header Value(s)</th>\n"
                + "</tr>\n");

        while (headerNames.hasMoreElements()) {
            String paramName = (String) headerNames.nextElement();
            out.print("<tr><td>" + paramName + "</td>\n");
            String paramValue = request.getHeader(paramName);
            out.println("<td> " + paramValue + "</td></tr>\n");
        }
        out.println("</table>\n");
    }
}
