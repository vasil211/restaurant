package com.bari.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bari.dao.UserDao;
import com.bari.model.User;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/listuser.jsp";
	private UserDao dao;

	public UserController() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			String user_Id = request.getParameter("user_Id");
			dao.deleteUser(user_Id);
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			String user_Id = request.getParameter("user_Id");
			User user = dao.getUserById(user_Id);
			request.setAttribute("user", user);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("users", dao.getAllUsers());
		} else {
			forward = INSERT_OR_EDIT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		User user = dao.checkIfUserExist(uname, password);
		if (user != null) {
			request.getSession().setAttribute("isLogged", true);
			request.getSession().setAttribute("username", user.getUname());
			request.getSession().setAttribute("roleId", user.getRoles_id());
			response.sendRedirect(request.getContextPath() + "/dashboard");
		} else {
			response.sendRedirect(request.getContextPath() + "/index.jsp?error=wrongNameOrPass");
		}
		
//		User user = new User();
//		user.setUname(request.getParameter("Uname"));
//		user.setPassword(request.getParameter("password"));

//		try {
//			System.out.println("rrrrrrrrrrr" + reg);
//			user.setRegistration(reg);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		user.setEmail(request.getParameter("Email"));
//		String userid = request.getParameter("Uname");
//		if (userid == null || userid.isEmpty()) {
//			dao.addUser(user);
//		} else { // user.setUname(userid); //
//			dao.checkUser(user);
//		}
//
//		RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
//		request.setAttribute("users", dao.getAllUsers());
//		view.forward(request, response);
	}
}