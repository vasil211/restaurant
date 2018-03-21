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
		String email = request.getParameter("Email");
		String chEmail = dao.validEmail(email);

		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
//		user.setEmail(request.getParameter("Email"));
		user.setEmail(chEmail);
		user.setPassword(hashedPass);
		user.setUname(request.getParameter("uname"));
		user.setPhone(request.getParameter("phone"));
		user.setEGN(request.getParameter("EGN"));
		boolean added = dao.addUser(user);

		if (added) {
			System.out.println("Record has been inserted");
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=Registered");

		} else {
			System.out.println("failed to insert the data");
			String registrationError = "Registration Error";
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=Registration Error");
		}

	}

}
