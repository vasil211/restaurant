package com.bari.controller;

import java.io.IOException;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import com.bari.dao.UserDao;
import com.bari.model.User;



public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
   
    public RegistrationController() {
        super();
        dao = new UserDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pass=request.getParameter("Password");
		String hashedPass= dao.hash(pass);
		User user = new User();
		user.setFirstName(request.getParameter("FirstName")); 
		user.setLastName(request.getParameter("LastName"));  
		user.setEmail(request.getParameter("Email"));  
		user.setPassword(hashedPass); 
		user.setUname(request.getParameter("Uname"));
		user.setPhone(request.getParameter("Phone"));  
		user.setEGN(request.getParameter("EGN"));
		boolean added = dao.addUser(user);
		 
		
        
		if (added) {
			System.out.println("<font size='6' color=blue>" + "Record has been inserted" + "</font>");
			response.sendRedirect(request.getContextPath() + "/index.jsp");

		} else {
			System.out.println("<font size='6' color=blue>" + "failed to insert the data" + "</font>");
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=registrationError");
		}
		
	
		
	}
	
	
}
	
		

