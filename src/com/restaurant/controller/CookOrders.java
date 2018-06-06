package com.restaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.restaurant.dao.MenuDao;

public class CookOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuDao dao;

	public CookOrders() {
		super();
		dao = new MenuDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("isLogged") != null) {
			// !!
			int roleId = (int) request.getSession().getAttribute("role_Id");

			if (roleId == 3) {

			}
		} else {
			String notLoggedIn = "Not Logged In";
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=" + notLoggedIn);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
