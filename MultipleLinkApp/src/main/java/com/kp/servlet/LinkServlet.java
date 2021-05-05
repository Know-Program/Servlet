package com.kp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// variables
		PrintWriter pw = null;
		String data = null;
		int n1 = 0;
		int n2 = 0;
		
		// set content type
		resp.setContentType("text/html");
		
		// get Writer
		pw = resp.getWriter();
		
		// read form data (only required data)
		data = req.getParameter("s1");
		// read val1 and val2 only when submit 
		// buttons are generating the request
		
		/* for submit buttons */ 
		if(data.equals("Add")) {
			// logic to perform addition operation
			n1 = Integer.parseInt(req.getParameter("val1"));
			n2 = Integer.parseInt(req.getParameter("val2"));
			pw.println("<h1>Addition = " + (n1 + n2) + "</h1>");
		} else if(data.equals("Sub")) {
			// logic to perform Subtraction operation
			n1 = Integer.parseInt(req.getParameter("val1"));
			n2 = Integer.parseInt(req.getParameter("val2"));
			pw.println("<h1>Subtraction = " + (n1 - n2) + "</h1>");
		} else if(data.equals("Multiply")) {
			// logic to perform Multiplication operation
			n1 = Integer.parseInt(req.getParameter("val1"));
			n2 = Integer.parseInt(req.getParameter("val2"));
			pw.println("<h1>Multiply = " + (n1 * n2) + "</h1>");
		}  
		
		/* for hyper links */
		else if(data.equals("link1")) {
			// display system date and time
			pw.println("Current system date and time:"
			            + new Date() );
		} else if(data.equals("link2")) {
			// display system properties
			pw.println("System Properties: " 
			           + System.getProperties());
		}
		
		// link to home
		pw.println("<h3><a href='form.html'>HOME</a></h3>");
		
		// close stream
		pw.close();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
