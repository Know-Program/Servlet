// ExcelServlet.java
package com.kp.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

public class ExcelServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {
            // set content type
	    res.setContentType("application/vnd.ms-excel");

	    // get printwriter 
	    PrintWriter pw = res.getWriter();

	    // write message to response object
	    pw.println(
	    	       "<table border='1' bgcolor='cyan' align='center'>"+
	    	       "<tr><th>Language</th> <th>Developer</th></tr>"+
	    	       "<tr><td>C</td> <td>Dennis M. Ritchie</td></tr>"+
	    	       "<tr><td>C++</td> <td>Bjarne Stroustrup</td></tr>"+
	    	       "<tr><td>Java</td> <td>James Gosling</td></tr>"+
	    	       "<tr><td>Python</td> <td>Guido van Rossum</td></tr>"+
	    	       "</table>"
	    	);

	    // close stream
	    pw.close();
    }  
}
