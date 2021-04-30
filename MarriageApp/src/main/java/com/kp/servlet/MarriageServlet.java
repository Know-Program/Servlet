package com.kp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// declare variables
		PrintWriter pw = null;
		String name = null;
		String gender = null;
		int age = 0;

		// set content type
		resp.setContentType("text/html");

		// get PrintWriter
		pw = resp.getWriter();

		// get form data
		name = req.getParameter("pname");
		gender = req.getParameter("gender");
		age = Integer.parseInt(req.getParameter("page"));

		// check age is valid or not
		if (age <= 0 || age >= 100) {
			pw.println("<h1>Please Enter Valid Age.</h1>");
			// stop execution
			return;
		}

		// business logic
		if (gender.equals("M")) {
			if (age >= 21)
				pw.println("<h1 style='color:green; text-align:center'>" +
			                 "Congratulation, Mr. " + name + 
			                 "<br>"	+ 
			                 "You are eligible for marriage." +
			               "</h1>");
			else
				pw.println("<h1 style='color:red; text-align:center'>" + 
			                 "Sorry, Mr. " + name + 
			                 "<br>" + 
			                 "You are not eligible for marriage." + 
			                 "<br>Enjoy your Life." +
			                "</h1>");
		} else {
			if (age >= 18)
				pw.println("<h1 style='color:green; text-align:center'>" +
			                 "Congratulation, Mrs. " + name + 
			                 "<br>"	+ 
			                 "You are eligible for marriage." +
			               "</h1>");
			else
				pw.println("<h1 style='color:red; text-align:center'>" + 
			                 "Sorry, Miss. " + name + 
			                 "<br>" + 
			                 "You are not eligible for marriage." + 
			                 "<br>Enjoy your Life." +
			               "</h1>");
		}
		
		// link to return home
		pw.println("<h3><a href='input.html'>Home</a></h3>");

		// close stream
		pw.close();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

}
