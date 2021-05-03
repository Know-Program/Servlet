package com.kp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckVoterServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// variables
		PrintWriter pw = null;
		String name = null;
		String tage = null;
		int age = 0;
		
		// set content type
		resp.setContentType("text/html");
		
		// get writer
		pw = resp.getWriter();
		
		// get form data
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		// convert tage to number
		age = Integer.parseInt(tage);
		
		// welcome message
		pw.println("<h1 style='text-align:center'>"+
				   "Election Commission</h1>");
		
		// business logic
		if(age >= 18) {
			pw.println("<h2 style='text-align:center; color: green'>"+
					   "Hello, " + name + " Congratulations! <br>" +
					   "You are eligible for voting.</h2>"
					  );
		} else {
			pw.println("<h2 style='text-align:center; color: red'>"+
					   "Hello, " + name + "<br>" +
					   "Sorry, You are not eligible for voting.<br>"+
					   "Please wait more " + (18-age) + " years.</h2>"
					  );
		}
		
		// link to home
		pw.println("<h4><a href='input.html'>Home</a></h4>");
		
		// close stream
		pw.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
