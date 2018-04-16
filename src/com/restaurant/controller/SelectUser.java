package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.UserDao;
import com.restaurant.model.User;

@WebServlet("/SelectUser")
public class SelectUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LIST_ALL_COOKS = "/cookList";
	private static String LIST_ALL_USERS = "/userList";
	private static String LIST_ALL_WAITERS = "/waiterList";
	private static String LIST_ALL_ADMINS = "/adminList";
	private UserDao dao;

	public SelectUser() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		System.out.println(action);
		if (action.equalsIgnoreCase("cook")) {
			//
			String user_Id = request.getParameter("user_Id");
			System.out.println(user_Id);
			List<com.restaurant.model.User> user = dao.getAllCooks();
			request.setAttribute("user", user);
			for (com.restaurant.model.User temp : user) {
				System.out.println(temp.getUname());
			}
		} else if (action.equalsIgnoreCase("user")) {
			String user_Id = request.getParameter("user_Id");
			System.out.println(user_Id);
			List<com.restaurant.model.User> user = dao.getAllUsers();
			forward = LIST_ALL_USERS;
			request.setAttribute("users", dao.getAllUsers());
			for (com.restaurant.model.User temp : user) {
				System.out.println(temp.getUname());
			}
		} else if (action.equalsIgnoreCase("waiter")) {
			String user_Id = request.getParameter("user_Id");
			System.out.println(user_Id);
			List<com.restaurant.model.User> user = dao.getAllWaiters();
			request.setAttribute("user", user);
			for (com.restaurant.model.User temp : user) {
				System.out.println(temp.getUname());
			}
		} else {
			String user_Id = request.getParameter("user_Id");
			System.out.println(user_Id);
			List<com.restaurant.model.User> user = dao.getAllAdmins();
			request.setAttribute("user", user);
			for (com.restaurant.model.User temp : user) {
				System.out.println(temp.getUname());
			}
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
