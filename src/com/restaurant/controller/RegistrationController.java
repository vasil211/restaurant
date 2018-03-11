package com.restaurant.controller;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import com.restaurant.dao.UserDao;
import com.restaurant.model.User;

import javax.mail.*;

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

		String pass = request.getParameter("Password");
		String hashedPass = dao.hash(pass);
		String email = request.getParameter("Email");
		String chEmail = dao.validEmail(email);
		
		User user = new User();
		user.setFirstName(request.getParameter("FirstName"));
		user.setLastName(request.getParameter("LastName"));
		user.setEmail(chEmail);
		user.setPassword(hashedPass);
		user.setUname(request.getParameter("Uname"));
		user.setPhone(request.getParameter("Phone"));
		user.setEGN(request.getParameter("EGN"));
		boolean added = dao.addUser(user);

		if (added) {
			System.out.println("Record has been inserted");
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=Registered");

		} else {
			System.out.println("failed to insert the data");
			String registrationError = "Registration Error";
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=registrationError");
		}

	}

}
