package com.restaurant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.model.User;

public class AdminFirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private static String USERS = "selectUser.jsp";
	// private static String ORDERS = "orders.jsp";
	// private static String MENU = "menu.jsp";
	// private static String TABLES = "tables.jsp";

	public AdminFirstPage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("isLogged") != null) {

			int roleId = (int) request.getSession().getAttribute("role_Id");
			if (roleId == 1) {
				// String forward = "";
				// String action = request.getParameter("action");
				// System.out.println(action);
				// if (action.equalsIgnoreCase("users")) {
				// forward = USERS;
				// } else if (action.equalsIgnoreCase("orders")) {
				// forward = ORDERS;
				// } else if (action.equalsIgnoreCase("menu")) {
				// forward = MENU;
				// } else {
				// forward = TABLES;
				// }
				request.getRequestDispatcher("/WEB-INF/adminFirstPage.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
