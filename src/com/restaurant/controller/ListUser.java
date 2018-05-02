package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.UserDao;

public class ListUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	public ListUser() {
		super();
		dao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getSession().getAttribute("isLogged") != null) {
			// !!
			int roleId = (int) request.getSession().getAttribute("role_Id");
			if (roleId == 1) {
				String action = request.getParameter("action");
				System.out.println("action: " + action);
				if (action.equalsIgnoreCase("cook")) {
					List<com.restaurant.model.User> user = dao.getAllCooks();
					request.setAttribute("user", user);
					for (com.restaurant.model.User temp : user) {
						System.out.println(temp.getEmail());
					}
				} else if (action.equalsIgnoreCase("user")) {
					List<com.restaurant.model.User> user = dao.getAllUsers();

					request.setAttribute("user", user);
					for (com.restaurant.model.User temp : user) {
						System.out.println(temp.getEmail());
					}
				} else if (action.equalsIgnoreCase("waiter")) {
					List<com.restaurant.model.User> user = dao.getAllWaiters();
					request.setAttribute("user", user);
					for (com.restaurant.model.User temp : user) {
						System.out.println(temp.getEmail());
					}
				} else {
					List<com.restaurant.model.User> user = dao.getAllAdmins();
					request.setAttribute("user", user);
					for (com.restaurant.model.User temp : user) {
						System.out.println(temp.getEmail());
					}
				}
				request.getRequestDispatcher("/WEB-INF/userList.jsp").forward(request, response);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=notLoggedIn");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
