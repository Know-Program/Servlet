package com.kp.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class DateServlet extends HttpServlet {
   public void service(HttpServletRequest req, HttpServletResponse res) 
      throws ServletException, IOException {

      // set response content type
      res.setContentType("text/html");

      // get PrintWriter 
      PrintWriter pw = res.getWriter();

      // business logic 
      Date d = new Date();
      // write output message to response object
      // using PrintWriter obj
      pw.println("<h1>Welcome to Servlet</h1>");
      pw.println("<h2>Date and time::"+ d.toString() +"</h2>");

      // close stream
      pw.close();
   }
}