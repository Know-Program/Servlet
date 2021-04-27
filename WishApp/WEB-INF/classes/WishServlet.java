package com.kp.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class WishServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) 
                throws ServletException, IOException {
        // declare variables
        PrintWriter pw = null;
        Calendar cal = null;
        int hour = 0;

        // set content type
        res.setContentType("text/html");
        // get PrintWriter object
        pw = res.getWriter();

        // Get system date and hour
        cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        // gives hour in 24 HOUR format

        // conditions for different result
        if(hour>=5 && hour<12)
            pw.println("<h1 style='color:green; text-align:center'>Good Morning</h1>");
        else if(hour>=12 && hour<17)
            pw.println("<h1 style='color:blue; text-align:center'>Good After-noon</h1>");
        else if(hour>=17 && hour<20)
            pw.println("<h1 style='color:orange; text-align:center'>Good Evening</h1>");
        else
            pw.println("<h1 style='color:yellow; text-align:center'>Good Night</h1>");

        // link to return back to the home
        pw.println("<h2><a href='home.html'>HOME</h2>");

        // close stream
        pw.close();
    }
}