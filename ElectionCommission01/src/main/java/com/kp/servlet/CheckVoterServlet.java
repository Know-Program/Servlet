package com.kp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		List<String> errList = null;
		
		// set content type
		resp.setContentType("text/html");
		
		// get writer
		pw = resp.getWriter();
		
		// welcome message
		pw.println("<h1 style='text-align:center'>"+
				   "Election Commission</h1>");
		
		// get form data
	    name = req.getParameter("pname");
	    tage = req.getParameter("page");
	    
	    // Server side form validation logic
		// Form validation logic
		errList = new ArrayList<String>();
		if(name == null || name.length()==0 || name.equals(" ")) {
			errList.add("Person name is required");
		}else if(name.length() <= 5){
			errList.add("Person name must have minimum 5 Characters.");
		}
		if(tage == null || tage.length() == 0 || tage.equals(" ")) {
			errList.add("Person age is required");
		} else {
			try {
				age = Integer.parseInt(tage);
				// check age is valid or not
				if (age <= 0 || age >= 125) {
					errList.add("Person age must be between 1 to 125.");
				}
			} catch(NumberFormatException nfe) {
				errList.add("Person age must be numeric value.");
			}
		}
		
		// display form validation error messages
		if(errList.size() != 0) {
			for (String errMsg : errList) {
				pw.println("<li><span style='color:red'>" + errMsg + "</span></li>");
			}
			return; // stop
		}
		
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
