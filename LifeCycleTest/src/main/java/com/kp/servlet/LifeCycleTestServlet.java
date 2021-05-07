package com.kp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class LifeCycleTestServlet extends HttpServlet {
	static {
		System.out.println("LifeCycleTestServlet: staic block");
	}
	public LifeCycleTestServlet() {
		System.out.println("LifeCycleTestServlet: 0-param Constructor");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LifeCycleTestServlet: init(-) method");
	}
	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("LifeCycleTestServlet: service(-,-) method");
		// set response content type
		resp.setContentType("text/html");
		// get Writer
		PrintWriter pw = resp.getWriter();
		// write response
		pw.println("<h1>Current Date and Time: "+
		           new Date() + "</h1>");
		// link to home
		pw.println("<h3><a href='index.html'>Home</a></h3>");
		// close stream
		pw.close();
	}
	@Override
	public void destroy() {
		System.out.println("LifeCycleTestServlet: destroy() method");
	}
}
