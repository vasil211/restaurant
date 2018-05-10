package com.restaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.UserDao;
import com.restaurant.model.User;

public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public RegistrationController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass = request.getParameter("password");
		String hashedPass = dao.hash(pass);
		String email = request.getParameter("email");
		String chEmail = dao.validEmail(email);
		System.out.println(chEmail);
//		String unameCh = request.getParameter("uname");
//		String validUname = dao.UnameValidator(validedUname);

		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setEmail(chEmail);
		user.setPassword(hashedPass);
		user.setUname(request.getParameter("uname"));
		user.setPhone(request.getParameter("phone"));
		user.setEGN(request.getParameter("EGN"));
		boolean added = dao.addUser(user);

		if (added) {
			System.out.println("Record has been inserted");
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?success=Registered");

		} else if ("firstName" == null) {
			System.out.println("Missing firstName");
			String wrongfirstName = "Missing First Name";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + wrongfirstName);

		} else if ("lastName" == null) {
			System.out.println("Missing lastName");
			String wronglastName = "Missing Last Name";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + wronglastName);

		} else if (chEmail == null) {
			System.out.println("wrong Email");
			String wrongEmail = "Wrong Email";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + wrongEmail);

		} else if (hashedPass == null) {
			System.out.println("Missing Password");
			String wrongPassword = "Missing Password";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + wrongPassword);

		} else if ("uname" == null) {
			System.out.println("Missing uname");
			String wrongUname = "Missing Uname";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + wrongUname);

		} else if ("phone" == null) {
			System.out.println("wrong phone");
			String wrongPhone = "Wrong phone";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + wrongPhone);

		} else if ("EGN" == null) {
			System.out.println("Missing EGN");
			String wrongEGN = "Missing EGN";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + wrongEGN);
		} else {
			System.out.println("failed to insert the data");
			String registrationError = "Registration Error";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + registrationError);
		}

	}
	
	

}
