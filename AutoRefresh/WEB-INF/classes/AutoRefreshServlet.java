package com.kp.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class AutoRefreshServlet extends HttpServlet {
 public void service(HttpServletRequest req, HttpServletResponse res)
 throws ServletException, IOException {

     // set content type
     res.setContentType("text/html");

     // get stream object
     PrintWriter pw = res.getWriter();

     // display date and time
     pw.println("<h1>Date and time :: " 
                + new java.util.Date() + "</h1>");

     // auto refresh after every 3 second
     res.setIntHeader("refresh", 3);

     // close stream
     pw.close();
  }
}