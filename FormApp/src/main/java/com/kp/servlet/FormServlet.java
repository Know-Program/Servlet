package com.kp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// declare variables
		String name = null;
		String tage = null;
		String gender = null;
		String addr = null;
		String mstatus = null;
		String qlfy = null;
		String hobbies[] = null;
		PrintWriter pw=null;
		int age = 0;
		
		// set content type
		resp.setContentType("text/html");
		
		// get Writer
		pw = resp.getWriter();
		
		// read form data
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		gender = req.getParameter("gender");
		addr = req.getParameter("add");
		mstatus = req.getParameter("ms");
		qlfy = req.getParameter("qlfy");
		hobbies = req.getParameterValues("hb");
		
		// convert age to numeric value
		age = Integer.parseInt(tage);
		
		// gender
		if(gender.equals("m")) {
			gender = "Male";
		} else if(gender.equals("f")) {
			gender = "Female";
		} else {
			gender = "Other";
		}
		
		// marital status
		if(mstatus == null) {
			mstatus = "Unmarried";
		}
		
		// check hobbies selected or not
		if(hobbies == null) {
			hobbies = new String[]{"No Hobbies are selected"};
		}
		
		// display data
		pw.println("<h1 style='text-align:center'>"
				+ "Personal Detail of " + name + "</h1>"
				+ "<div>"
				+ "Name:: " + name + "<br>"
				+ "Age:: " + age + "<br>"
				+ "Gender:: " + gender + "<br>"
				+ "Address:: " + addr + "<br>"
				+ "Marital Status:: " + mstatus + "<br>"
				+ "Qualification:: " + qlfy + "<br>"
				+ "Hobbies:: " + Arrays.toString(hobbies)
				+ "</div>");
		
		// link to home
		pw.println("<h3><a href='form.html'>HOME</a></h3>");
		
		// close stream
		pw.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}
}
