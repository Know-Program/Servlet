package com.kp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LangServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// variables
		PrintWriter pw = null;
		int langCode = 0;
		String creators[] = null;

		// creators
		creators = new String[] { 
				"Dennis Ritchie", "Bjarne Stroustrup", 
				"James Gosling", "Guido van Rossum"};

		// set content type
		resp.setContentType("text/html");

		// get PrintWriter
		pw = resp.getWriter();

		// get form data
		langCode = Integer.parseInt(req.getParameter("language"));
		
		// result
		pw.println("<h1 style='text-align:center'>Creator Name is:: "+ 
		            creators[langCode] + "</h1>");
		
		// link to home
		pw.println("<h3><a href='page.html'>HOME</a></h3>");
		
		// close stream
		pw.close();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
