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

	public AdminFirstPage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("isLogged") != null) {

			int roleId = (int) request.getSession().getAttribute("role_Id");
			if (roleId == 1) {
		
				request.getRequestDispatcher("/WEB-INF/adminFirstPage.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/loginPage.jsp?error=notLoggedIn");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
